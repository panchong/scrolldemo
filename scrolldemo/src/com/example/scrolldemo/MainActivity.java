package com.example.scrolldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

	private Button m_Btnbar1 = null;
	private Button m_Btnbar2 = null;
	private Button m_Btnbar3 = null;
	private Button m_Btnbar4 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        m_Btnbar1 = (Button) this.findViewById(R.id.btnbar1);
        m_Btnbar1.setOnClickListener(this);
        m_Btnbar2 = (Button) this.findViewById(R.id.btnbar2);
        m_Btnbar2.setOnClickListener(this);
        m_Btnbar3 = (Button) this.findViewById(R.id.btnbar3);
        m_Btnbar3.setOnClickListener(this);
        m_Btnbar4 = (Button) this.findViewById(R.id.btnbar4);
        m_Btnbar4.setOnClickListener(this);
    }
    
    
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}



	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == m_Btnbar1) {
	        startActivity(new Intent("com.example.viewpager.ViewPagerActivity"));
	    } else if (v == m_Btnbar2) {
	        startActivity(new Intent("com.example.viewflipper.ViewFlipperActivity"));
	    } else if (v == m_Btnbar3) {
	        startActivity(new Intent("com.example.viewflow.ViewFlowActivity"));
	    } else if (v == m_Btnbar4){
	    	startActivity(new Intent("com.example.downloadimage.ImageActivity"));
	    }
	}

}
