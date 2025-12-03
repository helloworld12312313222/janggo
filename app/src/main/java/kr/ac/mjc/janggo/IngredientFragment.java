package kr.ac.mjc.janggo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class IngredientFragment extends Fragment {

    public interface OnIngredientSelectedListener {
        void onIngredientSelected(String ingredientName);
    }

    private OnIngredientSelectedListener listener;

    private MaterialButton meatBt, fishBt, vegetableBt, eggBt, fruitBt, riceBt, milkBt, tofuBt, seasoningBt, spicesBt, breadBt, soupBt, noodleBt, dessertBt, instantBt;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnIngredientSelectedListener) {
            listener = (OnIngredientSelectedListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ingredient, container, false);

        meatBt = rootView.findViewById(R.id.meat_bt);
        fishBt = rootView.findViewById(R.id.fish_bt);
        vegetableBt = rootView.findViewById(R.id.vegetable_bt);
        eggBt = rootView.findViewById(R.id.egg_bt);
        fruitBt = rootView.findViewById(R.id.fruit_bt);
        riceBt = rootView.findViewById(R.id.rice_bt);
        milkBt = rootView.findViewById(R.id.milk_bt);
        tofuBt = rootView.findViewById(R.id.tofu_bt);
        seasoningBt = rootView.findViewById(R.id.seasoning_bt);
        spicesBt = rootView.findViewById(R.id.spices_bt);
        breadBt = rootView.findViewById(R.id.bread_bt);
        soupBt = rootView.findViewById(R.id.soup_bt);
        noodleBt = rootView.findViewById(R.id.noodle_bt);
        dessertBt = rootView.findViewById(R.id.dessert_bt);
        instantBt = rootView.findViewById(R.id.instant_bt);

        MaterialButton[] buttons = {meatBt, fishBt, vegetableBt, eggBt, fruitBt, riceBt, milkBt, tofuBt, seasoningBt, spicesBt, breadBt, soupBt, noodleBt, dessertBt, instantBt};

        for (MaterialButton btn : buttons) {
            btn.setOnClickListener(v -> {
                String ingredientName = ((MaterialButton) v).getText().toString();
                if (listener != null) {
                    listener.onIngredientSelected(ingredientName);
                }
            });
        }

        return rootView;
    }
}