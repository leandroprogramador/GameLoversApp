package leandro.com.gameloversapp.Presentation.Main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.Presentation.Detalhes.DetalhesActivity;
import leandro.com.gameloversapp.Presentation.Main.Adapters.MainRecyclerAdapter;
import leandro.com.gameloversapp.R;


public class GameFragment extends Fragment implements MainRecyclerAdapter.IGameClick {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return view;
    }

    public void setAdapter(List<Game> games){
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(games, GameFragment.this);
        recyclerView.setAdapter(mainRecyclerAdapter);
    }

    @Override
    public void onClick(Game game) {
        int gameID = game.getId();
        Intent intent = new Intent(getActivity(), DetalhesActivity.class);
        intent.putExtra(getString(R.string.game_id), gameID);
        startActivity(intent);
    }
}
