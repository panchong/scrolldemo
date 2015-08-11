package com.example.viewpager;


import java.util.ArrayList;
import java.util.List;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;





public class SecondFragment extends Fragment implements OnItemClickListener {
	
	private ListView mListView;
	
	private int[] mImages = new int[] { R.drawable.zte, R.drawable.huawei,
            R.drawable.datang, R.drawable.bodao, R.drawable.meizu,
            R.drawable.lenovo, R.drawable.xiaomi, R.drawable.oppo,
            R.drawable.gionee };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View v = inflater.inflate(R.layout.second_fragment_layout, container,
	                false);
	        return v;
	}

	@SuppressLint("NewApi") @Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mListView = view.findViewById(R.id.group_listview);
		mListView.setAdapter(new GroupAdapter(getActivity()));
		mListView.setOnItemClickListener(this);
		super.onViewCreated(view, savedInstanceState);
	}
	
	 @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        // TODO Auto-generated method stub
        Item item = (Item) mListView.getAdapter().getItem(position);
        new AlertDialog.Builder(getActivity())
                .setTitle(item.getName())
                .setMessage(item.getDetail())
                .setIcon(android.R.drawable.ic_menu_more)
                .setNegativeButton(android.R.string.cancel,
                        new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                // TODO Auto-generated method stub

                            }
                        }).create().show();
    }
	 
    private class GroupAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater mInflater;
        private List<Item> mData = new ArrayList<Item>();

        public GroupAdapter(Context ctx) {
            mContext = ctx;
            mInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            initData();
        }

        public void setData(List<Item> data) {
            mData = data;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        @Override
        public Item getItem(int position) {
            // TODO Auto-generated method stub
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.second_item_layout,
                        null);
            }
            ViewHolder holder = new ViewHolder();
            holder.mIcon = (ImageView) convertView.findViewById(R.id.img);
            holder.mGroupName = (TextView) convertView
                    .findViewById(R.id.item_name);
            holder.mGroupName.setText(getItem(position).getName());
            holder.mGroupAnnouncement = (TextView) convertView
                    .findViewById(R.id.item_detail);
            holder.mGroupAnnouncement.setText(getItem(position).getDetail());
            return convertView;
        }

        private void initData() {
            String[] names = getStringArray(R.array.group_names);
            String[] details = getStringArray(R.array.group_details);
            for (int i = 0; i < mImages.length; i++) {
                mData.add(new Item(mImages[i], names[i], details[i]));
            }
        }

        private String[] getStringArray(int resId) {
            return mContext.getResources().getStringArray(resId);
        }

        private class ViewHolder {
            ImageView mIcon;
            TextView mGroupName;
            TextView mGroupAnnouncement;
        }

    }
}