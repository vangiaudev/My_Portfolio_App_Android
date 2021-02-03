package vangiaurecca.example.myportfolioapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;

import java.util.List;

import vangiaurecca.example.myportfolioapplication.cv.CVFragment;
import vangiaurecca.example.myportfolioapplication.home.HomeFragment;
import vangiaurecca.example.myportfolioapplication.portfolio.PortfolioFragment;
import vangiaurecca.example.myportfolioapplication.sidemenu.Callback;
import vangiaurecca.example.myportfolioapplication.sidemenu.MenuAdapter;
import vangiaurecca.example.myportfolioapplication.sidemenu.MenuItem;
import vangiaurecca.example.myportfolioapplication.sidemenu.MenuUtil;
import vangiaurecca.example.myportfolioapplication.skill.SkillFragment;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView rvMenu;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        
        //setup side menu
        setupSideMenu();

        //set the default fragment when activity launch
        setHomeFragment();
        
        //setHomeFragment();
        //setCVFragment();
        //setSkillFragment();
        //setPortfolioFragment();
    }

    private void setupSideMenu() {
        rvMenu = findViewById(R.id.rvSideMenu);

        //get menu list item will get data from a static data class

        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems, this);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setAdapter(adapter);
    }


    void setPortfolioFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }
    void setSkillFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SkillFragment()).commit();
    }
    void setCVFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }
    void setHomeFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()){
            case MenuUtil.HOME_FRAGMENT_CODE: setHomeFragment();
            break;
            case MenuUtil.CV_FRAGMENT_CODE: setCVFragment();
            break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE: setPortfolioFragment();
            break;
            case MenuUtil.SKILL_FRAGMENT_CODE: setSkillFragment();
            break;
            default: setHomeFragment();
        }

        //hightlight the selected menu item
        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i;
        adapter.notifyDataSetChanged();

    }
}