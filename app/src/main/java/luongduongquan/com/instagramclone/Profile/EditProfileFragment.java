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

import com.nostra13.universalimageloader.core.ImageLoader;

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


        initImageLoader();
        saveProfileSettings();
        return view;
    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    private void saveProfileSettings(){

        Log.d(TAG, "saveProfileSettings: setting profile image");
        String url = "https://mk0gizmoidsbgcpdmtk7.kinstacdn.com/wp-content/uploads/2015/11/REL-Android.png";
        UniversalImageLoader.setImage(url, imgProfilePhoto,null, "");
        
    }
}
