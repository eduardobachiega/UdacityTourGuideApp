package eduardobachiega.udacitytourguideapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eduardobachiega.udacitytourguideapp.R;
import eduardobachiega.udacitytourguideapp.adapter.MenuRecyclerAdapter;
import eduardobachiega.udacitytourguideapp.model.MenuItem;

public class MenuActivity extends AppCompatActivity {
    @BindView(R.id.rvMenuItems)
    RecyclerView rvMenuItems;

    Context context = MenuActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        rvMenuItems.setLayoutManager(new LinearLayoutManager(context));
        MenuRecyclerAdapter adapter = new MenuRecyclerAdapter(setupMenuItems());
        rvMenuItems.setAdapter(adapter);
        adapter.setOnItemClickListener(new MenuRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, PlacesActivity.class);
                intent.putExtra("ITEM", position);
            }
        });
    }

    private List<MenuItem> setupMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(getString(R.string.menu_restaurant),
                getString(R.string.descr_restaurant), R.drawable.ic_restaurant));
        items.add(new MenuItem(getString(R.string.menu_hotels),
                getString(R.string.descr_hotels), R.drawable.ic_hotels));
        items.add(new MenuItem(getString(R.string.menu_malls),
                getString(R.string.descr_malls), R.drawable.ic_malls));
        items.add(new MenuItem(getString(R.string.menu_parks),
                getString(R.string.descr_parks), R.drawable.ic_parks));
        items.add(new MenuItem(getString(R.string.menu_transport),
                getString(R.string.descr_transport), R.drawable.ic_transport));
        return items;
    }
}
