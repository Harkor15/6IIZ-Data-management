package harkor.weather.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import harkor.weather.Adapters.ForecastRecyclerViewAdapter;
import harkor.weather.Interfaces.FiveDaysWeatherInterface;
import harkor.weather.Model.WeatherObject;
import harkor.weather.R;
import harkor.weather.ViewModel.FiveDaysWeatherViewModel;


public class FiveDaysWeatherFragment extends Fragment implements FiveDaysWeatherInterface {
    RecyclerView recyclerView;
    ImageView refresh;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_five_days_weather,container,false);
        final FiveDaysWeatherViewModel fiveDaysWeatherViewModel =new FiveDaysWeatherViewModel(this);
        fiveDaysWeatherViewModel.setListViewData();
        recyclerView=view.findViewById(R.id.forecast_recycler_view);
        refresh=view.findViewById(R.id.image_refresh);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fiveDaysWeatherViewModel.setListViewData();
            }
        });
        return view;
    }

    @Override
    public void setListViewAdapter(WeatherObject[] weatherObjects) {
        recyclerView.setHasFixedSize(true);
        ForecastRecyclerViewAdapter forecastRecyclerViewAdapter=new ForecastRecyclerViewAdapter(weatherObjects);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(forecastRecyclerViewAdapter);
    }
}
