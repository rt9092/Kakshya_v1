package in.wadersgroup.hth;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Romil
 * 
 */
public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;

	public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.list_row, null);

		TextView title = (TextView) vi.findViewById(R.id.title); // title
		TextView artist = (TextView) vi.findViewById(R.id.artist); // artist
																	// name

		ImageView thumb_image = (ImageView) vi.findViewById(R.id.list_image); // thumb
																				// image

		HashMap<String, String> song = new HashMap<String, String>();
		song = data.get(position);

		// Setting all values in listview
		title.setText(song.get(NGOFragment.KEY_TITLE));
		Typeface type2 = Typeface.createFromAsset(vi.getContext().getAssets(),
				"fonts/RobotoCondensed-Light.ttf");
		artist.setTypeface(type2);

		if (song.get(NGOFragment.KEY_DURATION).length() > 30) {
			String partString = song.get(NGOFragment.KEY_DURATION).substring(0,
					30);

			artist.setText(partString + "...");
		} else {
			artist.setText(song.get(NGOFragment.KEY_DURATION));
		}

		imageLoader.DisplayImage(song.get(NGOFragment.KEY_THUMB_URL),
				thumb_image);
		return vi;
	}
}