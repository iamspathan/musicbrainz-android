package org.metabrainz.mobile.presentation.features.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.metabrainz.mobile.R;
import org.metabrainz.mobile.presentation.features.login.LoginSharedPreferences;

public class WelcomeFragment extends Fragment {

    private TextView welcomeText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_dash_welcome, container);
        welcomeText = layout.findViewById(R.id.welcome_text);
        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateText();
    }

    private void updateText() {
        if (LoginSharedPreferences.getLoginStatus() == LoginSharedPreferences.STATUS_LOGGED_IN) {
            String message = getString(R.string.welcome_loggedin) + " " + LoginSharedPreferences.getUsername();
            welcomeText.setText(message);
        } else {
            welcomeText.setText(R.string.welcome);
        }
    }

}
