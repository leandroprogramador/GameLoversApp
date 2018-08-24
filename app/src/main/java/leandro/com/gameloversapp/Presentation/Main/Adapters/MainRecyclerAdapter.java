package leandro.com.gameloversapp.Presentation.Main.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.R;
import leandro.com.gameloversapp.Utils.PicassoHelper;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>{

    public MainRecyclerAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }

    List<Game> gameList;
    Context context;
    @NonNull
    @Override
    public MainRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_games, parent, false);
        return new MainRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewHolder holder, int position) {
        Game game = gameList.get(position);
        holder.txtGame.setText(game.getName());
        if(game.getCover()!=null) {
            PicassoHelper.getImage(game.getCover().getUrl(), holder.imgCover, R.drawable.image_error);
        }
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    class MainRecyclerViewHolder extends RecyclerView.ViewHolder{


        ImageView imgCover;
        TextView txtGame;
        public MainRecyclerViewHolder(View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.imgCapa);
            txtGame = itemView.findViewById(R.id.txtGame);
        }
    }
}
