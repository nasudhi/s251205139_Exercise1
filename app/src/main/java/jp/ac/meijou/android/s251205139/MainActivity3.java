package jp.ac.meijou.android.s251205139;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;

import jp.ac.meijou.android.s251205139.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    private int display;
    private int operand1;
    private int operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main3);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String sentText = intent.getStringExtra("editText");
        binding.calcField.setText(sentText);

        Optional.ofNullable(getIntent().getStringExtra("text"))
                        .ifPresent(text -> binding.calcField.setText(text));

        binding.buttonOk.setOnClickListener(view -> {
            var ok_intent = new Intent();
            ok_intent.putExtra("ret", "OK");
            setResult(RESULT_OK, ok_intent);
            finish();
        });

        binding.buttonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });

        binding.button0.setOnClickListener(view -> {

        });
        binding.button1.setOnClickListener(view -> {

        });
        binding.button2.setOnClickListener(view -> {

        });
        binding.button3.setOnClickListener(view -> {

        });
        binding.button4.setOnClickListener(view -> {

        });
        binding.button5.setOnClickListener(view -> {

        });
        binding.button6.setOnClickListener(view -> {

        });
        binding.button7.setOnClickListener(view -> {

        });
        binding.button8.setOnClickListener(view -> {

        });
        binding.button9.setOnClickListener(view -> {

        });
        binding.buttonPlus.setOnClickListener(view -> {

        });
        binding.buttonMinus.setOnClickListener(view -> {

        });
        binding.buttonMultiply.setOnClickListener(view -> {

        });
        binding.buttonDivide.setOnClickListener(view -> {

        });
        binding.buttonEqual.setOnClickListener(view -> {

        });
        binding.buttonAC.setOnClickListener(view -> {

        });
    }
    private void pushOperand(int num) {

    }
}