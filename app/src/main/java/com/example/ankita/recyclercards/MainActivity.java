package com.example.ankita.recyclercards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;
    private Button buttonAdd, buttonDelete;

    private EditText editTextAdd, editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFakeData();
        recyclerViewConfig();

        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);

        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = Integer.parseInt(editTextAdd.getText().toString());
                addCard(position);

            }

            private void addCard(int position) {
            }
        });

    }

    private void generateFakeData() {

        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.node, "Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner, "CLicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor, "CLicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.threer, "CLicked at Greece"));
        exampleList.add(new ExampleItem(R.drawable.fourr, "CLicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fiver, "CLicked at Santorini"));
        exampleList.add(new ExampleItem(R.drawable.sixr, "CLicked at India"));
    }

    private void recyclerViewConfig() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    public void addCard(int position){
        exampleList.add(position, new ExampleItem(R.drawable.node, "new card added"));
        adapter.notifyItemInserted(position);
    }

    public void deleteCard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }

}
