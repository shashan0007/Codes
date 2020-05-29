package info.nitsri.slidingmenu;

import android.R;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FindPeopleFragment extends Fragment {
	
	public FindPeopleFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);
        Button admin = (Button)findViewByid(R.id.button1);
        admin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), adminclick.class);
                startActivityForResult(myIntent, 0);
            }
        });
                Button student = (Button) findViewById(R.id.button2);
                admin.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(view.getContext(), studentclick.class);
                        startActivityForResult(myIntent, 0);
                    }
                });
                Button company = (Button) findViewById(R.id.button3);
                admin.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(view.getContext(), studentclick.class);
                        startActivityForResult(myIntent, 0);
                    }
                });
             
        return rootView;
    }
}
