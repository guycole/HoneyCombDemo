package com.digiburo.honeycomb.app;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 * HoneyComb demonstration
 */
public class MainActivity extends Activity implements CustomListener, ActionBar.TabListener {

  /**
   * CustomListener.onCustomEvent()
   */
  @Override
  public void onCustomEvent(String arg) {
    LogFacade.entry(LOG_TAG, "onCustomEvent:" + arg);
    
    textView1.setText(arg);
  }

  /**
   * ActionBar.TabListener
   */
  @Override
  public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    LogFacade.entry(LOG_TAG, "onTabSelected:" + tab.getTag());

    if (tab.getTag().equals(TAG_TAB1)) {
      fragmentTransaction.add(R.id.fragmentContent01, fragment1, TAG_TAB1);
    } else if (tab.getTag().equals(TAG_TAB2)) {
      fragmentTransaction.add(R.id.fragmentContent01, fragment2, TAG_TAB2);
    } else {
      throw new IllegalArgumentException("unknown tab:" + tab.getTag());
    }

    LogFacade.exit(LOG_TAG, "onTabSelected:" + tab.getTag());
  }

  /**
   * ActionBar.TabListener
   * @param tab
   * @param fragmentTransaction
   */
  @Override
  public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    LogFacade.entry(LOG_TAG, "onTabUnselected:" + tab.getTag());

    if (tab.getTag().equals(TAG_TAB1)) {
      fragmentTransaction.remove(fragment1);
    } else if (tab.getTag().equals(TAG_TAB2)) {
      fragmentTransaction.remove(fragment2);
    } else {
      throw new IllegalArgumentException("unknown tab:" + tab.getTag());
    }

    LogFacade.exit(LOG_TAG, "onTabUnselected:" + tab.getTag());
  }

  /**
   * ActionBar.TabListener
   * @param tab
   * @param fragmentTransaction
   */
  @Override
  public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    LogFacade.entry(LOG_TAG, "onTabReselected:" + tab.getTag());

    if (tab.getTag().equals(TAG_TAB1)) {
      //empty
    } else if (tab.getTag().equals(TAG_TAB2)) {
      //empty
    } else {
      throw new IllegalArgumentException("unknown tab:" + tab.getTag());
    }

    LogFacade.exit(LOG_TAG, "onTabReselected:" + tab.getTag());
  }

  /**
   * OptionMenu
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return(true);
  }
  
  /**
   * OptionMenu
   */
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    LogFacade.entry(LOG_TAG, "onOptionsItemSelected:" + item.getItemId());

    switch (item.getItemId()) {
   
    case android.R.id.home:
      //app icon in action bar
      LogFacade.debug(LOG_TAG, "option menu home");
      return true;
    case R.id.option_menu_1:
      LogFacade.debug(LOG_TAG, "option menu one");
      return(true);
    case R.id.option_menu_2:
      LogFacade.debug(LOG_TAG, "option menu two");
      return(true);
    case R.id.option_menu_3:
      LogFacade.debug(LOG_TAG, "option menu three");
      return(true);
    default:
      return super.onOptionsItemSelected(item);
    }
  }
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    LogFacade.entry(LOG_TAG, "onCreate");

    textView1 = (TextView) findViewById(R.id.textContent01);

    fragment1 = (FragmentOne) Fragment.instantiate(this, FragmentOne.class.getName());
    fragment2 = (FragmentTwo) Fragment.instantiate(this, FragmentTwo.class.getName());

    setupActionBar();
    
    Button changeButton = (Button) findViewById(R.id.buttonChange01);
    changeButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        LogFacade.debug(LOG_TAG, "change state");
        
        Time time = new Time();
        time.setToNow();
    
        textView1.setText(time.toString());
      }
    });
  }
  
  /**
   * 
   */
  private void setupActionBar() {
    LogFacade.entry(LOG_TAG, "setupActionBar");

    ActionBar actionBar = getActionBar();
    actionBar.setHomeButtonEnabled(true);
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    Tab tab1 = actionBar.newTab();
    tab1.setTabListener(this);
    tab1.setTag(TAG_TAB1);
    tab1.setText(R.string.main_menu_tab1);

    Tab tab2 = actionBar.newTab();
    tab2.setTabListener(this);
    tab2.setTag(TAG_TAB2);
    tab2.setText(R.string.main_menu_tab2);

    actionBar.addTab(tab1);
    actionBar.addTab(tab2);
  }

  //
  public static final String TAG_TAB1 = "TAG_TAB1";
  public static final String TAG_TAB2 = "TAG_TAB2";
  
  //
  private Fragment fragment1;
  private Fragment fragment2;

  //
  private TextView textView1;

  //
  private final String LOG_TAG = getClass().getName();
}