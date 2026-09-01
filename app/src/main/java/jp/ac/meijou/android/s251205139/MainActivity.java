package jp.ac.meijou.android.s251205139;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205139.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.textView.setText(R.string.name);
        binding.imagePokemon.setImageResource(R.drawable.baseline_catching_monbo_24);

        binding.changeButton.setOnClickListener(view ->{
            var text = binding.editTextText.getText().toString();
            if ("a".equals(text)) {
                binding.textView.setText("モンスターボールの画像");
                binding.imagePokemon.setImageResource(R.drawable.baseline_catching_monbo_24);
            }else if ("b".equals(text)) {
                binding.textView.setText("マスターボールの画像");
                binding.imagePokemon.setImageResource(R.drawable.baseline_catching_pokemon_24);
            }else{
                binding.textView.setText("スーパーボールの画像");
                binding.imagePokemon.setImageResource(R.drawable.baseline_catching_superball_24);
            }
        });

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                binding.textView.setText(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
        prefDataStore = PrefDataStore.getInstance(this);

        binding.saveButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name",text);
        });

        prefDataStore.getString("name").ifPresent(name -> {
            if ("a".equals(name)) {
                binding.textView.setText("モンスターボールの画像");
                binding.imagePokemon.setImageResource(R.drawable.baseline_catching_monbo_24);
            }else if ("b".equals(name)) {
                binding.textView.setText("マスターボールの画像");
                binding.imagePokemon.setImageResource(R.drawable.baseline_catching_pokemon_24);
            }else{
                binding.textView.setText("スーパーボールの画像");
                binding.imagePokemon.setImageResource(R.drawable.baseline_catching_superball_24);
            }

        });
    }
}