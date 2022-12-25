package kr.ac.mjc.ict2018261001.airhockey.Spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.ac.mjc.ict2018261001.airhockey.Spinner.Players;

import org.w3c.dom.Text;

import kr.ac.mjc.ict2018261001.airhockey.R;

public class PlayersAdapter extends BaseAdapter {

    private Context context;
    private List<Players> playersList;

    public PlayersAdapter(Context context, List<Players> playersList) {
        this.context = context;
        this.playersList = playersList;
    }

    @Override
    public int getCount() {
        return playersList != null ? playersList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return playersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_players, viewGroup, false);

        TextView textName = rootView.findViewById(R.id.name);

        textName.setText(playersList.get(i).getName());

        return rootView;
    }
}
