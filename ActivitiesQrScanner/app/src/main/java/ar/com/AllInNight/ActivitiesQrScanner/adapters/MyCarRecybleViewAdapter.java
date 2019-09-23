package ar.com.AllInNight.ActivitiesQrScanner.adapters;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ar.com.AllInNight.ActivitiesQrScanner.R;
import ar.com.AllInNight.ActivitiesQrScanner.beans.Car;
import ar.com.AllInNight.ActivitiesQrScanner.fragments.MyCarsFragment;
import ar.com.AllInNight.ActivitiesQrScanner.listeners.onMoveAndSwipedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCarRecybleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements onMoveAndSwipedListener {

    private Context context;
    private List<Car> mItems;
    private int color = 0;
    private MyCarsFragment.OnMyCarsFragmentInteractionListener listener;

    public MyCarRecybleViewAdapter(Context context, MyCarsFragment.OnMyCarsFragmentInteractionListener listener) {
        this.context = context;
        mItems = new ArrayList();
        this.listener = listener;
    }

    public void setItems(List<Car> data) {
        this.mItems.addAll(data);
        notifyDataSetChanged();
    }



    public void setColor(int color) {
        this.color = color;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ItemCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Car car = this.mItems.get(position);

        if (holder instanceof ItemCarViewHolder) {

            final ItemCarViewHolder recyclerViewHolder = (ItemCarViewHolder) holder;

            recyclerViewHolder.rela_round.setBackground(ContextCompat.getDrawable(context, car.getDrawableId()));
            recyclerViewHolder.myCarItemChasis.setText("Chasis " + car.getVin());
            recyclerViewHolder.myCarItemPatente.setText("Patente " +car.getPatent());
            String title = car.getBrand() + " " + car.getModel() + " " + car.getYear();

            recyclerViewHolder.myCarItemTitle.setText(title);

            Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_recycler_item_show);
            recyclerViewHolder.mView.startAnimation(animation);

            AlphaAnimation aa1 = new AlphaAnimation(1.0f, 0.1f);
            aa1.setDuration(400);
            recyclerViewHolder.rela_round.startAnimation(aa1);

            AlphaAnimation aa = new AlphaAnimation(0.1f, 1.0f);
            aa.setDuration(400);

            recyclerViewHolder.rela_round.startAnimation(aa);

            recyclerViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMyCarCardSelected(car);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }


    private class ItemCarViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        private RelativeLayout rela_round;
        private TextView myCarItemTitle;
        private TextView myCarItemChasis;
        private TextView myCarItemPatente;

        private ItemCarViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            rela_round = itemView.findViewById(R.id.rela_round);

            myCarItemTitle = itemView.findViewById(R.id.myCarItemTitle);
            myCarItemChasis = itemView.findViewById(R.id.myCarItemChasis);
            myCarItemPatente = itemView.findViewById(R.id.myCarItemPatente);

        }
    }
}
