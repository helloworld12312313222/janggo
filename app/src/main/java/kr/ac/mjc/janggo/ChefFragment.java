package kr.ac.mjc.janggo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.ac.mjc.janggo.dto.Chef;
import kr.ac.mjc.janggo.dto.Ingredient;

public class ChefFragment extends Fragment {

    private static final String ARG_INGREDIENT = "ingredient";
    private Ingredient ingredient;
    private RecyclerView chefRv;
    private OnChefSelectedListener listener;

    public static ChefFragment newInstance(Ingredient ingredient) {
        ChefFragment fragment = new ChefFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_INGREDIENT, ingredient);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnChefSelectedListener) {
            listener = (OnChefSelectedListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ingredient = (Ingredient) getArguments().getSerializable(ARG_INGREDIENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_chef, container, false);

        chefRv = rootView.findViewById(R.id.chef_rv);
        chefRv.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Chef> chefs = new ArrayList<>();
        chefs.add(new Chef(R.drawable.saemkim, "샘 킴", "어떤 재료든 무궁무진한 요리의\n신세계를 펼치는 키친 위의 성자!\n소울 푸드의 대명사!"));
        chefs.add(new Chef(R.drawable.kimpung, "김풍", "상상을 초월하는 기발한 레시피로\n요리계에 한 획을 그은 창의력 만렙, 요리인!\n이제는 셰프들을 위협하는 요리 실력까지 보유!\n웹툰 작가 겸 국내 최강 요리 애호가"));
        chefs.add(new Chef(R.drawable.leeyeonbok, "이연복", "요리 경력 47년차! 중화요리계의 살아있는 전설!\n극찬을 부르는 경이로운 요리 내공으로\n세계인들의 입맛까지 사로잡은 중식의 대가!"));
        chefs.add(new Chef(R.drawable.ohsedeuk, "오세득", "프렌치부터 하이브리드 야매(?)까지!\n전 장르를 넘나드는 셰프계의 멀티 플레이어!"));
        chefs.add(new Chef(R.drawable.reimeonkim, "레이먼킴", "섬세한 손길과 디테일이 살아있는 요리로\n반전 매력을 뽐내는 쿠킹마초!"));
        chefs.add(new Chef(R.drawable.jeonghoyeong, "정호영", "<냉장고를 부탁해> 공식 댄싱머신!\n순박한 외모 속에 감춰진 화려한 스킬!\n게스트의 입맛을 저격하는 일식 고수!"));
        chefs.add(new Chef(R.drawable.yuhyeonsu, "유현수", "맛은 물론, 스토리가 담겨있는 요리로\n게스트에게 감동을 선사하는 한식 셰프!"));
        chefs.add(new Chef(R.drawable.songhun, "송훈", "미국 미슐랭 레스토랑에서 내공을 쌓은\n20년차 경력의 아메리칸 다이닝 고수!\n요리의 맛과 멋을 추구하는 카리스마 셰프!"));
        chefs.add(new Chef(R.drawable.mikael, "미카엘", "캡틴 불가리아, 여심을 사로잡는 꽃미남 셰프!\n국내 유일 불가리아 레스토랑 오너 셰프"));
        chefs.add(new Chef(R.drawable.kimseungmin, "김승민", "요리 경력 23년차!\n도쿄 유학파 출신의 정통 일식 셰프\n마음을 담은 요리로 감동을 전하는 순정파 셰프!"));

        ChefAdapter adapter = new ChefAdapter(chefs, chef -> {
            if (listener != null) {
                listener.onChefSelected(chef, ingredient);
            }
        });

        chefRv.setAdapter(adapter);

        return rootView;
    }

    public interface OnChefSelectedListener {
        void onChefSelected(Chef chef, Ingredient ingredient);
    }
}