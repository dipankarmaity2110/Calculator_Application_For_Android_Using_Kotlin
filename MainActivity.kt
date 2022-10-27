package com.example.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    // declare variable
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonpercent: android.widget.Button
    lateinit var buttonclear: android.widget.Button
    lateinit var buttondot: android.widget.Button
    lateinit var buttonequal: android.widget.Button
    lateinit var buttonadd: android.widget.Button
    lateinit var buttonsub: android.widget.Button
    lateinit var buttonmul: android.widget.Button
    lateinit var buttondivide: android.widget.Button
    lateinit var buttonbackspace: android.widget.Button
    lateinit var inputex: EditText
    lateinit var resulttex: EditText
    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // hide action bar
        supportActionBar?.hide()
        // set button
        button0 = findViewById(R.id.button0)
        button00 = findViewById(R.id.button00)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonpercent = findViewById(R.id.buttonpercent)
        buttonclear = findViewById(R.id.clear)
        buttondot = findViewById(R.id.buttondot)
        buttonequal = findViewById(R.id.buttonequal)
        buttonadd = findViewById(R.id.buttonadd)
        buttonsub = findViewById(R.id.buttonminus)
        buttonmul = findViewById(R.id.buttonmultiply)
        buttondivide = findViewById(R.id.buttondivide)
        buttonbackspace = findViewById(R.id.buttonbackspace)
        resulttex = findViewById(R.id.result)
        inputex = findViewById(R.id.inputnumber)

        // set inputtex
        inputex.movementMethod = ScrollingMovementMethod()
        inputex.setActivated(true)
        inputex.setPressed(true)

        // declare
        var text: String

        // when click button for taking numbers
        button1.setOnClickListener{
            text = inputex.text.toString() + "1"
            inputex.setText(text)
            result(text)
        }

        button2.setOnClickListener{
            text = inputex.text.toString() + "2"
            inputex.setText(text)
            result(text)
        }

        button3.setOnClickListener{
            text = inputex.text.toString() + "3"
            inputex.setText(text)
            result(text)
        }

        button4.setOnClickListener{
            text = inputex.text.toString() + "4"
            inputex.setText(text)
            result(text)
        }

        button5.setOnClickListener{
            text = inputex.text.toString() + "5"
            inputex.setText(text)
            result(text)
        }

        button6.setOnClickListener{
            text = inputex.text.toString() + "6"
            inputex.setText(text)
            result(text)
        }

        button7.setOnClickListener{
            text = inputex.text.toString() + "7"
            inputex.setText(text)
            result(text)
        }

        button8.setOnClickListener{
            text = inputex.text.toString() + "8"
            inputex.setText(text)
            result(text)
        }

        button9.setOnClickListener{
            text = inputex.text.toString() + "9"
            inputex.setText(text)
            result(text)
        }

        button0.setOnClickListener{
            text = inputex.text.toString() + "0"
            inputex.setText(text)
            result(text)
        }

        button00.setOnClickListener{
            text = inputex.text.toString() + "00"
            inputex.setText(text)
            result(text)
        }

        buttondot.setOnClickListener{
            text = inputex.text.toString() + "."
            inputex.setText(text)
            result(text)
        }

        // when click operators button
        buttonadd.setOnClickListener{
            text = inputex.text.toString() + "+"
            inputex.setText(text)
            check = check + 1
        }

        buttonmul.setOnClickListener{
            text = inputex.text.toString() + "*"
            inputex.setText(text)
            check = check + 1
        }

        buttonsub.setOnClickListener{
            text = inputex.text.toString() + "-"
            inputex.setText(text)
            check = check + 1
        }

        buttondivide.setOnClickListener{
            text = inputex.text.toString() + "/"
            inputex.setText(text)
            check = check + 1
        }

        buttonpercent.setOnClickListener{
            text = inputex.text.toString() + "%"
            inputex.setText(text)
            check = check + 1
        }


        // when click button equal
        buttonequal.setOnClickListener {
            text = resulttex.text.toString()
            inputex.setText(text)
            resulttex.setText(null)
        }

        //when click button clear
        buttonclear.setOnClickListener{
            inputex.setText(null)
            resulttex.setText(null)
        }


        // when click button backspace
        buttonbackspace.setOnClickListener{
            var BackSpace: String?=null
            if(inputex.text.length > 0) {
                val stringBuilder: StringBuilder = StringBuilder(inputex.text)
                val find = inputex.text.toString()
                val find2 = find.last()
                if(find2.equals('+') || find2.equals('-') || find2.equals('/') || find2.equals('*') || find2.equals('%')) {
                    check = check - 1;

                }
                stringBuilder.deleteCharAt(inputex.text.length - 1)
                BackSpace = stringBuilder.toString()
                inputex.setText(BackSpace)
                result(BackSpace)
            }
        }




    }

    private fun result(text: String) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            val mainr = result.toString()
            if(check == 0) {
                resulttex.setText(null)
            }
            else {
                resulttex.setText(mainr)
            }
        }
        catch(e: ScriptException) {
            Log.d("TAG", "ERROR")
        }

    }
}