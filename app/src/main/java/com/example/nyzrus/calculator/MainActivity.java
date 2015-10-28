package com.example.nyzrus.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.view.Gravity;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    public String str ="", tempOp="";
    Character op = 'q';
    int i;
    Double num, numtemp;
    Double eqnum = 0.0;
    EditText showResult;
    boolean eq = false;

    @Override
    public void onClick(View v) {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showResult = (EditText)findViewById(R.id.display);
        //showResult.setGravity(Gravity.RIGHT);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void receiveClick(View v){
        int buttonID = v.getId();
        switch(buttonID){
            case R.id.one:
                insert(1);
                eq = false;
                break;
            case R.id.two:
                insert(2);
                eq = false;
                break;
            case R.id.three:
                insert(3);
                eq = false;
                break;
            case R.id.four:
                insert(4);
                eq = false;
                break;
            case R.id.five:
                insert(5);
                eq = false;
                break;
            case R.id.six:
                insert(6);
                eq = false;
                break;
            case R.id.seven:
                insert(7);
                eq = false;
                break;
            case R.id.eight:
                insert(8);
                eq = false;
                break;
            case R.id.nine:
                insert(9);
                eq = false;
                break;
            case R.id.zero:
                insert(0);
                eq = false;
                break;

        }

    }

    public void opClick(View v){
        int buttonID = v.getId();
        switch(buttonID) {
            case R.id.C:
                reset();
                break;
            case R.id.plus:
                perform();
                op = '+';
                eq = false;
                break;
            case R.id.neg:
                plusMinus();
                perform();
                eq = false;
                break;
            case R.id.minus:
                perform();
                op = '-';
                eq = false;
                break;
            case R.id.multiply:
                perform();
                op = '*';
                eq = false;
                break;
            case R.id.divide:
                perform();
                op = '/';
                eq = false;
                break;
            case R.id.decimal:
                decimal();
                eq = false;
                break;
            case R.id.equals:
                if(eq == true){
                    calculate();
                }else{
                    calculate();
                    eq = true;
                }
                break;
        }
    }


    private void reset() {
        str ="";
        op ='q';
        num = 0.0;
        numtemp = 0.0;
        showResult.setText("");
    }

    private void insert(int j) {
         if(eq==true){
             str = "";
             str = str+Integer.toString(j);
             num = Double.parseDouble(str);
             showResult.setText(str);
         }else {
             str = str + Integer.toString(j);
             num = Double.parseDouble(str);
             showResult.setText(str);
         }
    }
    private void perform() {
        str = "";
        numtemp = num;
    }
    private void calculate() {
        if(eq==true){
            numtemp = num;
            num = eqnum;
        }
        else{
            eqnum = num;
        }
        if(op.equals('+')) {
            num = numtemp + num;
        }
        else if(op.equals('-')) {
            num = numtemp - num;
        }
        else if(op.equals('/')) {
            num = numtemp / num;
        }
        else if(op.equals('*')) {
            num = numtemp * num;
        }
        showResult.setText(""+num);
    }

    public void plusMinus(){
        num = num * -1;
        showResult.setText(""+num);
    }

    public void decimal(){
        if(num%1 == 0){
            long temp = Math.round(num);
            str = ""+temp+".";
            showResult.setText(str);

        }else{
            showResult.setText("Nope, can't do that");
        }

    }

}