package com.digiburo.honeycomb.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digiburo.honeycomb.app.LogFacade;

/**
 * simple demonstration fragment
 * 
 * @author gsc
 */
public class SimpleLabelFragment extends Fragment {
  
  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    LogFacade.debug(LOG_TAG, "onAttach");
  }
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogFacade.debug(LOG_TAG, "onCreate");
  }
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    LogFacade.debug(LOG_TAG, "onCreateView");
    
    View view = inflater.inflate(R.layout.fragment_simple, container, false);
    return(view);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    LogFacade.debug(LOG_TAG, "onActivityCreated");
  }

  @Override
  public void onStart() {
    super.onStart();
    LogFacade.debug(LOG_TAG, "onStart");
  }
  
  @Override
  public void onResume() {
    super.onResume();
    LogFacade.debug(LOG_TAG, "onResume");
  }

  @Override
  public void onPause() {
    super.onPause();
    LogFacade.debug(LOG_TAG, "onPause");
  }

  @Override
  public void onStop() {
    super.onStop();
    LogFacade.debug(LOG_TAG, "onStop");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    LogFacade.debug(LOG_TAG, "onDestroyView");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    LogFacade.debug(LOG_TAG, "onDestroy");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    LogFacade.debug(LOG_TAG, "onDetach");
  }

	//
	private final String LOG_TAG = getClass().getName();
}

/*
* Copyright 2011 Digital Burro, INC
* Created on Jan 16, 2011 by gsc
*/
