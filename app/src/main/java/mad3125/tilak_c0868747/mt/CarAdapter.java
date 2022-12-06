package mad3125.tilak_c0868747.mt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import mad3125.tilak_c0868747.mt.databinding.ItemCarDropdownBinding;

public class CarAdapter extends ArrayAdapter<Car> {

    Context context;

    public CarAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            Car car = Car.cars.get(position);
            ItemCarDropdownBinding binding = ItemCarDropdownBinding.inflate(
                    LayoutInflater.from(context),parent,false
            );
            binding.getRoot().setText(car.getName());
            return binding.getRoot();
        }
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return Car.cars.size();
    }

    @Nullable
    @Override
    public Car getItem(int position) {
        return Car.cars.get(position);
    }
}
