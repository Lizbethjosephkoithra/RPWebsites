package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spCat;
    Spinner spSub;
    Button btnGo;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aacategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCat=findViewById(R.id.spinnerCat);
        spSub=findViewById(R.id.spinnerSub);
        btnGo=findViewById(R.id.buttonGo);

        alCategory=new ArrayList<>();
        aacategory=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, alCategory);
        spSub.setAdapter(aacategory);


        spCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] strCat;
                int pos=spCat.getSelectedItemPosition();
                alCategory.clear();

                switch(i){
                    case 0:
                        strCat=getResources().getStringArray(R.array.Subcategory1);
                        alCategory.addAll(Arrays.asList(strCat));
                        spSub.setSelection(0);

                        btnGo.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                int pos=spSub.getSelectedItemPosition();
                                alCategory.clear();

                                if(pos == 0){
                                    String url = getResources().getString(R.string.homepage);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                } else {
                                    String url = getResources().getString(R.string.student_life);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                }
                            }

                        });

                        break;

                    case 1:
                        strCat=getResources().getStringArray(R.array.Subcategory2);
                        alCategory.addAll(Arrays.asList(strCat));
                        spSub.setSelection(1);

                        btnGo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int pos=spSub.getSelectedItemPosition();
                                alCategory.clear();

                                if(pos == 0){
                                    String url = getResources().getString(R.string.dmsd);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                } else {
                                    String url = getResources().getString(R.string.dit);
                                    Intent intent = new Intent(getBaseContext(), Webpage.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                }
                            }
                        });

                        break;

                }
                aacategory.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}

