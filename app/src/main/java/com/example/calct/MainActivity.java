package com.example.calct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    double num1 = 0, num2 = 0;

    TextView results;
    boolean Addition, Subtraction, Multiplication, Division, Modulus, Opposite, Root, Square, Fraction, Decimal;

    Button zero, one, two, three, four, five, six, seven, eight, nine;
    Button add, subtract, divide, multiply, equals, clear, clearall, point, mod, opp, sqroot, squared, fractioned, back, history;

    private static final String FILE_NAME = "CalcText.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUIViews();
        if (savedInstanceState != null) {
            String calculations = savedInstanceState.getString("calculations");
            if (calculations != null) {
                results.setText(calculations);
            }
        }

        history = (Button) findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistoryPage();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText(results.getText() + "0");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    Addition = true;
                    Decimal = false;
                    results.setText(null);
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    Subtraction = true;
                    Decimal = false;
                    results.setText(null);
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    Multiplication = true;
                    Decimal = false;
                    results.setText(null);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    Division = true;
                    Decimal = false;
                    results.setText(null);
                }
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    Modulus = true;
                    Decimal = false;
                    results.setText(null);
                }
            }
        });

        opp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    num2 = Double.NaN;
                    Opposite = true;
                    Decimal = false;

                    results.setText(-1 * num1 + "");
                }
            }
        });

        sqroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    num2 = Double.NaN;
                    Root = true;
                    Decimal = false;

                    results.setText(Math.sqrt(num1) + "");
                }
            }
        });

        squared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    Square = true;
                    Decimal = false;

                    results.setText(num1 * num1 + "");
                }
            }
        });

        fractioned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (results.getText().length() != 0) {
                    num1 = Double.parseDouble(results.getText() + "");
                    num2 = Double.NaN;
                    Fraction = true;
                    Decimal = false;

                    results.setText(1 / num1 + "");
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addition || Subtraction || Multiplication || Division || Modulus) {
                    num2 = Double.parseDouble(results.getText() + "");
                }
                if (Addition) {
                    results.setText(num1 + num2 + "");
                    Addition = false;
                }
                if (Subtraction) {
                    results.setText(num1 - num2 + "");
                    Subtraction = false;
                }
                if (Multiplication) {
                    results.setText(num1 * num2 + "");
                    Multiplication = false;
                }
                if (Division) {
                    results.setText(num1 / num2 + "");
                    Division = false;
                }
                if (Modulus) {
                    results.setText(num1 % num2 + "");
                    Modulus = false;
                }

                    /*File file = new File("CalcResults.txt");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    try {
                        FileWriter writer = new FileWriter(file, true);
                        writer.append(results.getText().toString() + "\n");
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/

                    String text = (results.getText().toString() + "\n");
                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                        fos.write(text.getBytes());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(results.getText().length() > 0){
                    CharSequence name = results.getText().toString();
                    results.setText(name.subSequence(0, name.length() - 1));
                }
                else{
                    num1 = Double.NaN;
                    num2 = Double.NaN;
                    results.setText("");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText("");
            }
        });

        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.setText("");
                num1 = 0.0;
                num2 = 0.0;
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Decimal) {
                    //do nothing or you can show the error
                } else {
                    results.setText(results.getText() + ".");
                    Decimal = true;
                }

            }
        });
    }
    private void setUpUIViews(){
            zero = (Button) findViewById(R.id.zero);
            one = (Button) findViewById(R.id.one);
            two = (Button) findViewById(R.id.two);
            three = (Button) findViewById(R.id.three);
            four = (Button) findViewById(R.id.four);
            five = (Button) findViewById(R.id.five);
            six = (Button) findViewById(R.id.six);
            seven = (Button) findViewById(R.id.seven);
            eight = (Button) findViewById(R.id.eight);
            nine = (Button) findViewById(R.id.nine);
            point = (Button) findViewById(R.id.point);
            add = (Button) findViewById(R.id.add);
            subtract = (Button) findViewById(R.id.subtract);
            multiply = (Button) findViewById(R.id.multiply);
            divide = (Button) findViewById(R.id.divide);
            mod = (Button) findViewById(R.id.modulus);
            opp = (Button) findViewById(R.id.opposite);
            sqroot = (Button) findViewById(R.id.root);
            squared = (Button) findViewById(R.id.square);
            fractioned = (Button) findViewById(R.id.fraction);
            clear = (Button) findViewById(R.id.clear);
            clearall = (Button) findViewById(R.id.clearall);
            back = (Button) findViewById(R.id.back);
            equals = (Button) findViewById(R.id.equals);
            results = (TextView) findViewById(R.id.results);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        setUpUIViews();
        String calculations = results.getText().toString();
        savedInstanceState.putString("calculations", calculations);
        super.onSaveInstanceState(savedInstanceState);
    }

    /*public void save(View v){
        String CalcResults = results.getText().toString();
        FileOutputStream fos = null;

        try{
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(CalcResults.getBytes());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    /*public void load(View v){
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            results.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    public void openHistoryPage(){
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }
}