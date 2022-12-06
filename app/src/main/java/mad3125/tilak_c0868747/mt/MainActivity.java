package mad3125.tilak_c0868747.mt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.google.android.material.chip.ChipGroup;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import mad3125.tilak_c0868747.mt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CarAdapter adapter;
    int count = 0;
    Car selectedCar;
    DriverAge age;

    private static final double TAX = 0.13;

    private static final double YOUTH = 5.0;
    private static final double ADULT = 0.0;
    private static final double SENIOR = -10.0;

    private static final double GPS = 5.0;
    private static final double CHILD_SEAT = 7.0;
    private static final double MILEAGE = 10.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createCarList();
        adapter = new CarAdapter(this,R.layout.item_car_dropdown);
        binding.spinner.setPrompt("Please choose a car.");
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCar = (Car) adapterView.getSelectedItem();
                binding.etDailyRent.setText(
                        getString(R.string.value_dailyRent,selectedCar.getPrice())
                );
                calculatePrices();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                count = i;
                binding.tvDaysHint.setText(count+" days");
                calculatePrices();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.checkGps.setOnCheckedChangeListener((compoundButton, b) -> calculatePrices());
        binding.checkChildSeat.setOnCheckedChangeListener((compoundButton, b) -> calculatePrices());
        binding.checkMileage.setOnCheckedChangeListener((compoundButton, b) -> calculatePrices());
        binding.radioGroup.setOnCheckedChangeListener((radioGroup, i) -> calculatePrices());

        binding.btnAction.setOnClickListener( v->{
            if(count == 0){
                showMessage("You need to book for more than 0 days");
                return;
            }
            if(binding.radioGroup.getCheckedRadioButtonId() == -1){
                showMessage("Please choose the drivers age.");
                return;
            }
            Rent rent = new Rent(selectedCar,count,age,new ArrayList<>());
            showMessage("Order has been placed for "+selectedCar.getName());
            Intent intent = new Intent(this,InfoActivity.class);
            startActivity(intent);

        });
    }

    private void showMessage(String msg){
        Snackbar.make(binding.getRoot(),msg,Snackbar.LENGTH_SHORT).show();
    }

    private void createCarList(){
        Car.cars.clear();
        Car.cars.add(new Car(1,"BMW",45.0));
        Car.cars.add(new Car(2,"Audi",55.0));
        Car.cars.add(new Car(3,"Cadillac",30));
        Car.cars.add(new Car(4,"Volks Wagon",39.0));
        Car.cars.add(new Car(5,"Mercedes",77.0));
        Car.cars.add(new Car(6,"Puegeot",89.0));
        Car.cars.add(new Car(7,"Ferrari",155.0));
        Car.cars.add(new Car(9,"Lamborghini",399.99));
    }

    private void calculatePrices(){

        int id  = binding.radioGroup.getCheckedRadioButtonId();
        if(id == -1){
            return;
        }
        double cost = selectedCar.getPrice();
        switch (id){
            case -1 :
                return;
            case R.id.radioYouth:
                age = DriverAge.LESS_THAN_20;
                cost += YOUTH;
                break;
            case R.id.radioAdult:
                age = DriverAge.BETWEEN_20_AND_60;
                cost += 0;
                break;
            case R.id.radioSenior:
                age = DriverAge.ABOVE_60;
                cost += SENIOR;
                break;
        }
        if(binding.checkGps.isChecked()){
            cost += GPS;
        }
        if(binding.checkChildSeat.isChecked()){
            cost += CHILD_SEAT;
        }
        if(binding.checkMileage.isChecked()){
            cost += MILEAGE;
        }

        double costForEntireTrip = cost * count;
        double tax = costForEntireTrip * TAX;
        double totalAmount = costForEntireTrip + tax;

        binding.tvAmount.setText(getString(R.string.value_price,costForEntireTrip));
        binding.tvTotal.setText(getString(R.string.value_price,totalAmount));

    }

    private void viewDetails(){

    }
}