package mad3125.tilak_c0868747.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import mad3125.tilak_c0868747.mt.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {

    Rent rent;
    ActivityInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rent = (Rent) getIntent().getSerializableExtra("data");

        binding.carName.setText(rent.getCar().getName());
        binding.tielPrice.setText(getString(R.string.value_price,rent.getCar().getPrice()));
        binding.tielDays.setText(rent.getNoOfDays()+"");
        binding.tielAge.setText(rent.getAge().toString());

        binding.tvOptions.setVisibility( (rent.getOptions().size() > 0) ? View.VISIBLE : View.GONE );
        binding.list.setVisibility( (rent.getOptions().size() > 0) ? View.VISIBLE : View.GONE );
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,rent.getOptions());
        binding.list.setAdapter(adapter);

        binding.tielAmount.setText(getString(R.string.value_price,rent.getTotalAmount()));
        binding.tielTotalPrice.setText(getString(R.string.value_price,rent.getTotalPrice()));
    }
}