package kr.ac.mjc.janggo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.ac.mjc.janggo.dto.Chef;
import kr.ac.mjc.janggo.dto.Ingredient;

public class FoodFragment extends Fragment {

    private static final String ARG_CHEF = "chef";
    private static final String ARG_INGREDIENT = "ingredient";

    private Chef chef;
    private Ingredient ingredient;

    public static FoodFragment newInstance(Chef chef, Ingredient ingredient) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHEF, chef);
        args.putSerializable(ARG_INGREDIENT, ingredient);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            chef = (Chef) getArguments().getSerializable(ARG_CHEF);
            ingredient = (Ingredient) getArguments().getSerializable(ARG_INGREDIENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food, container, false);
    }
}