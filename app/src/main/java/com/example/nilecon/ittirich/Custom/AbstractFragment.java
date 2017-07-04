package com.example.nilecon.ittirich.Custom;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Fragment.SettingFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/27/16 AD.
 */
public abstract class AbstractFragment extends Fragment {
    protected Activity activity;
    protected LayoutInflater inflater;
    protected ProgressDialog progressDialog;
    protected ActionBar actionBar;

    protected abstract int setContentView();

    protected abstract void bindActionbar(ImageView menuLeft, ImageView menuRight,RelativeLayout bg, TextView txtLogo);

    protected abstract void BindUI(View v);

    protected abstract void setupUI();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(setContentView(), container, false);
        setHasOptionsMenu(true);

        activity = getActivity();

        this.inflater = inflater;
        initActionbar();
        setProgressDialog();
        BindUI(v);
        setupUI();

        InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(v.getWindowToken(), 0);
        return v;
    }

    private void setProgressDialog() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Now Loading...");
        progressDialog.setCancelable(false);
    }

    private void initActionbar() {
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        LayoutInflater mInflater = LayoutInflater.from(activity);
        View mCustomView = mInflater.inflate(R.layout.layout_navigation_bar, null);
        RelativeLayout bgNavigation = (RelativeLayout) mCustomView.findViewById(R.id.bg);
        ImageView menuLeft = (ImageView) mCustomView.findViewById(R.id.menuLeft);
        ImageView menuRight = (ImageView) mCustomView.findViewById(R.id.menuRight);
        TextView txtLogo = (TextView) mCustomView.findViewById(R.id.navbar_txt);
        menuRight.setVisibility(View.INVISIBLE);
        menuLeft.setVisibility(View.INVISIBLE);
        menuLeft.setOnClickListener(onMenuClicked);
        menuRight.setOnClickListener(onMenuRightClicked);
        bindActionbar(menuLeft, menuRight,bgNavigation, txtLogo);

        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);
        Toolbar parent = (Toolbar) mCustomView.getParent();//first get parent toolbar of current action bar
        parent.setContentInsetsAbsolute(0, 0);// set padding programmatically to 0dp
        actionBar.show();
    }

    public void hideActionBar(){
        actionBar.hide();
    }

    public void replaceChlidFragment(Fragment fragment, Bundle bundle) {
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.tab_content_main, fragment)
                .addToBackStack(null).commit();
    }

    private View.OnClickListener onMenuClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().onBackPressed();
        }
    };
    private View.OnClickListener onMenuRightClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            replaceChlidFragment(new SettingFragment(), null);
        }
    };
}
