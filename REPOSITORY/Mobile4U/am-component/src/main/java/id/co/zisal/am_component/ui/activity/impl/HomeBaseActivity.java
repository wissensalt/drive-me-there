package id.co.zisal.am_component.ui.activity.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;

import id.co.zisal.am_component.R;
import id.co.zisal.am_component.ui.fragment.impl.MainFragment;
import id.co.zisal.am_component.ui.fragment.impl.ViewPagerFragment;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

/**
 * Created on 9/29/2015 : 12:34 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class HomeBaseActivity extends NavigationLiveo implements OnItemClickListener {

    protected HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle bundle) {
        // User Information
        this.userName.setText("Rudson Lima");
        this.userEmail.setText("rudsonlive@gmail.com");
        this.userPhoto.setImageResource(R.drawable.ic_rudsonlive);
        this.userBackground.setImageResource(R.drawable.ic_user_background_first);

        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.inbox), R.mipmap.ic_inbox_black_24dp, 7);
        mHelpLiveo.addSubHeader(getString(R.string.categories)); //Item subHeader
        mHelpLiveo.add(getString(R.string.starred), R.mipmap.ic_star_black_24dp);
        mHelpLiveo.add(getString(R.string.sent_mail), R.mipmap.ic_send_black_24dp);
        mHelpLiveo.add(getString(R.string.drafts), R.mipmap.ic_drafts_black_24dp);
        mHelpLiveo.addSeparator(); // Item separator
        mHelpLiveo.add(getString(R.string.trash), R.mipmap.ic_delete_black_24dp);
        mHelpLiveo.add(getString(R.string.spam), R.mipmap.ic_report_black_24dp, 120);

        //with(this, Navigation.THEME_DARK). add theme dark
        //with(this, Navigation.THEME_LIGHT). add theme light

        with(this) // default theme is dark
                .startingPosition(2) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(R.string.settings, R.mipmap.ic_settings_black_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){
            case 2:
                mFragment = new ViewPagerFragment();
                break;

            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };
}
