package luongduongquan.com.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import luongduongquan.com.instagramclone.R;
import luongduongquan.com.instagramclone.Utils.UniversalImageLoader;

/**
 * Created by User on 6/4/2017.
 */

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";

    private ImageView imgProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        Log.d(TAG, "onCreateView: init View");

        imgProfilePhoto = view.findViewById(R.id.profile_photo_EditProFile);
        saveProfileSettings();

		//back arrow for navigating back to "ProfileActivity"
		ImageView backArrow = (ImageView) view.findViewById(R.id.backArrow_EditProfile);
		backArrow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClick: navigating back to ProfileActivity");
				getActivity().finish();
			}
		});

        return view;
    }



    private void saveProfileSettings(){

        Log.d(TAG, "saveProfileSettings: setting profile image");
        String url = "https://mk0gizmoidsbgcpdmtk7.kinstacdn.com/wp-content/uploads/2015/11/REL-Android.png";
        UniversalImageLoader.setImage(url, imgProfilePhoto,null, "");
        
    }
}
