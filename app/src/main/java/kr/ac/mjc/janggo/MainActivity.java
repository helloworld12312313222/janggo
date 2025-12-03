package kr.ac.mjc.janggo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import kr.ac.mjc.janggo.dto.Chef;
import kr.ac.mjc.janggo.dto.Ingredient;

public class MainActivity extends AppCompatActivity implements IngredientFragment.OnIngredientSelectedListener,ChefFragment.OnChefSelectedListener {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment ingredientFragment = new IngredientFragment();
    private Fragment favoriteFragment = new FavoriteFragment();
    private Fragment videoFragment = new VideoFragment();
    private Fragment categoryFragment = new CategoryFragment();
    private Fragment aiChatFragment = new AIChatFragment();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        fragmentManager.beginTransaction()
                .replace(R.id.main_frame_layout, ingredientFragment)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int id = item.getItemId();

                if (id == R.id.fragment_ingredient) {
                    selectedFragment = ingredientFragment;
                } else if (id == R.id.fragment_favorite) {
                    selectedFragment = favoriteFragment;
                } else if (id == R.id.fragment_video) {
                    selectedFragment = videoFragment;
                } else if (id == R.id.fragment_category) {
                    selectedFragment = categoryFragment;
                } else if (id == R.id.fragment_chat) {
                    selectedFragment = aiChatFragment;
                }

                if (selectedFragment != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_frame_layout, selectedFragment)
                            .commitAllowingStateLoss();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onIngredientSelected(String in) {
        Ingredient ingredient = new Ingredient(in);
        Fragment chefFragment = ChefFragment.newInstance(ingredient);
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                )
                .replace(R.id.main_frame_layout, chefFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onChefSelected(Chef chef, Ingredient ingredient) {
        Fragment foodFragment = FoodFragment.newInstance(chef, ingredient);

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.fade_out
                )
                .replace(R.id.main_frame_layout, foodFragment)
                .addToBackStack(null)
                .commit();
    }
}
