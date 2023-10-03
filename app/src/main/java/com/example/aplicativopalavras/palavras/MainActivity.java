package com.example.aplicativopalavras.palavras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.aplicativopalavras.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private boolean linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearlayout = false;
        recyclerView = findViewById(R.id.recyclerview_letras);
        recyclerView.setAdapter(new LetrasAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        alterarLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem trocarLayoutButton = menu.findItem(R.id.trocar_layout);
        alterarIconeMenu(trocarLayoutButton);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.trocar_layout){
            alterarLayout();
            alterarIconeMenu(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alterarLayout() {
        linearlayout = !linearlayout;
        if (linearlayout){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }
    }

    private void alterarIconeMenu(MenuItem itemMenu) {
        if (itemMenu != null){
            if (linearlayout){
                itemMenu.setIcon(getDrawable(R.drawable.ic_grid));
            }else {
                itemMenu.setIcon(getDrawable(R.drawable.ic_lista));
            }
        }
    }
}