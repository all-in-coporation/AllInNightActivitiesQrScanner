package ar.com.AllInNight.ActivitiesQrScanner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.AllInNight.ActivitiesQrScanner.R;
import ar.com.AllInNight.ActivitiesQrScanner.beans.Accesory;

public class MyCarMerchandisingAdapter extends BaseAdapter {
    private Context context;

    public MyCarMerchandisingAdapter(Context context){
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return Accesory.merchandisingList().size();
    }

    @Override
    public Object getItem(int position) {
        return Accesory.merchandisingList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return Accesory.merchandisingList().get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grid_accesories, parent, false);
        }

        ImageView imagenCoche = (ImageView) view.findViewById(R.id.imagen_coche);
        TextView nombreCoche = (TextView) view.findViewById(R.id.nombre_coche);

        final Accesory item = (Accesory) getItem(position);
        imagenCoche.setImageResource(item.getImageResource());
        nombreCoche.setText(item.getName());

        return view;
    }
}
