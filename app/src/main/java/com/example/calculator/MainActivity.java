package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private final String PLUS = "+";
    private final String PERCENT = "%";
    private final String MINUS = "-";
    private final String MULTIPLICATION = "*";
    private final String DIVISION = "/";
    private final String EMPTY = "";
    private final String EQUAL = "=";
    private final String E = "e";
    private final int ONE_HUNDRED_PERCENT = 100;
    private final int ZERO_INT = 0;
    private final int ONE_INT = 1;
    private final int TWO_INT = 2;
    private final int SCALE_INT = 300;
    private final long VIBRATE_SECONDS = 25L;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_2200 = 162f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_2200 = 56f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_1536 = 113f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_1536 = 56f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_1440 = 78f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_1440 = 60f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_1080 = 79f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_1080 = 60f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_768 = 73f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_768 = 52f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_720 = 67f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_720 = 50f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_480 = 59f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_480 = 45f;
    private final float EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_320 = 60f;
    private final float BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_320 = 40f;
    private Button button_number_0;
    private Button button_number_1;
    private Button button_number_2;
    private Button button_number_3;
    private Button button_number_4;
    private Button button_number_5;
    private Button button_number_6;
    private Button button_number_7;
    private Button button_number_8;
    private Button button_number_9;
    private Button button_c;
    private Button button_plus_minus;
    private Button button_division;
    private Button button_backspace;
    private Button button_multiplication;
    private Button button_minus;
    private Button button_plus;
    private Button button_period;
    private Button button_equals;
    private Button button_percent;
    private EditText editText;
    private BigDecimal bigDecimal;
    private BigDecimal bigDecimalZero;
    private BigDecimal bigDecimalEqualsOperand2;
    private BigDecimal bigDecimalTemporaryPercent;
    private boolean isOperand1AlreadyFilled;
    private boolean isOperand2WaitFirstInput;
    private boolean isFinalResult;
    private boolean editTextContainsPoint;
    private boolean editTextEqualsError;
    private boolean isButtonPressed;
    private String operation;
    private String operationEquals;
    private String operationPrevious;
    private String operationTemporaryPercent;
    private double valueOfEditText;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        mFindViewById();
        mSetOnClickListener();
        mSetOnTouchListener();
        setValue();
    }

    private void mFindViewById() {
        button_number_0 = findViewById(R.id.button_number_0);
        button_number_1 = findViewById(R.id.button_number_1);
        button_number_2 = findViewById(R.id.button_number_2);
        button_number_3 = findViewById(R.id.button_number_3);
        button_number_4 = findViewById(R.id.button_number_4);
        button_number_5 = findViewById(R.id.button_number_5);
        button_number_6 = findViewById(R.id.button_number_6);
        button_number_7 = findViewById(R.id.button_number_7);
        button_number_8 = findViewById(R.id.button_number_8);
        button_number_9 = findViewById(R.id.button_number_9);
        button_c = findViewById(R.id.button_c);
        button_plus_minus = findViewById(R.id.button_plus_minus);
        button_division = findViewById(R.id.button_division);
        button_backspace = findViewById(R.id.button_backspace);
        button_multiplication = findViewById(R.id.button_multiplication);
        button_minus = findViewById(R.id.button_minus);
        button_plus = findViewById(R.id.button_plus);
        button_period = findViewById(R.id.button_period);
        button_equals = findViewById(R.id.button_equals);
        button_percent = findViewById(R.id.button_percent);
        editText = findViewById(R.id.edit_text);
    }

    private void mSetOnClickListener() {
        button_number_0.setOnClickListener(this);
        button_number_1.setOnClickListener(this);
        button_number_2.setOnClickListener(this);
        button_number_3.setOnClickListener(this);
        button_number_4.setOnClickListener(this);
        button_number_5.setOnClickListener(this);
        button_number_6.setOnClickListener(this);
        button_number_7.setOnClickListener(this);
        button_number_8.setOnClickListener(this);
        button_number_9.setOnClickListener(this);
        button_c.setOnClickListener(this);
        button_plus_minus.setOnClickListener(this);
        button_division.setOnClickListener(this);
        button_backspace.setOnClickListener(this);
        button_multiplication.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_period.setOnClickListener(this);
        button_equals.setOnClickListener(this);
        button_percent.setOnClickListener(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void mSetOnTouchListener() {
        button_number_0.setOnTouchListener(this);
        button_number_1.setOnTouchListener(this);
        button_number_2.setOnTouchListener(this);
        button_number_3.setOnTouchListener(this);
        button_number_4.setOnTouchListener(this);
        button_number_5.setOnTouchListener(this);
        button_number_6.setOnTouchListener(this);
        button_number_7.setOnTouchListener(this);
        button_number_8.setOnTouchListener(this);
        button_number_9.setOnTouchListener(this);
        button_c.setOnTouchListener(this);
        button_plus_minus.setOnTouchListener(this);
        button_division.setOnTouchListener(this);
        button_backspace.setOnTouchListener(this);
        button_multiplication.setOnTouchListener(this);
        button_minus.setOnTouchListener(this);
        button_plus.setOnTouchListener(this);
        button_period.setOnTouchListener(this);
        button_equals.setOnTouchListener(this);
        button_percent.setOnTouchListener(this);
    }

    private void resetValue() {
        bigDecimalZero = new BigDecimal(getString(R.string.zero));
        bigDecimalEqualsOperand2 = bigDecimalZero;
        bigDecimalTemporaryPercent = bigDecimalZero;
        bigDecimal = bigDecimalZero;
        operation = EMPTY;
        operationEquals = EMPTY;
        operationPrevious = EMPTY;
        operationTemporaryPercent = EMPTY;
        isOperand1AlreadyFilled = false;
        isOperand2WaitFirstInput = false;
        isFinalResult = false;
        editTextContainsPoint = false;
        isButtonPressed = false;
    }

    private void setValueForButtonPressed() {
        if (!operationPrevious.equals(EMPTY)) {
            isButtonPressed = true;
        }
    }

    private void activateOnClickEquals() {
        if (isButtonPressed) {
            onClickButtonEquals();
        }
    }

    private void setValue() {
        resetValue();
        setDigitsSizeInEditTextAndButtons();
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    private void setDigitsSizeInEditTextAndButtons() {
        switch (Resources.getSystem().getDisplayMetrics().widthPixels) {
            case 2200:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_2200,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_2200);
                break;
            case 1536:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_1536,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_1536);
                break;
            case 1440:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_1440,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_1440);
                break;
            case 1080:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_1080,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_1080);
                break;
            case 768:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_768,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_768);
                break;
            case 720:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_720,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_720);
                break;
            case 480:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_480,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_480);
                break;
            case 320:
                setSize(EDIT_TEXT_DIGITS_SIZE_DISPLAY_WIDTH_320,
                        BUTTON_DIGITS_SIZE_DISPLAY_WIDTH_320);
                break;
            default:
                break;
        }
    }

    private void setSize(float sizeEditText, float sizeButtonsText) {
        editText.setTextSize(sizeEditText);
        button_number_0.setTextSize(sizeButtonsText);
        button_number_1.setTextSize(sizeButtonsText);
        button_number_2.setTextSize(sizeButtonsText);
        button_number_3.setTextSize(sizeButtonsText);
        button_number_4.setTextSize(sizeButtonsText);
        button_number_5.setTextSize(sizeButtonsText);
        button_number_6.setTextSize(sizeButtonsText);
        button_number_7.setTextSize(sizeButtonsText);
        button_number_8.setTextSize(sizeButtonsText);
        button_number_9.setTextSize(sizeButtonsText);
        button_c.setTextSize(sizeButtonsText);
        button_plus_minus.setTextSize(sizeButtonsText);
        button_division.setTextSize(sizeButtonsText);
        button_backspace.setTextSize(sizeButtonsText);
        button_multiplication.setTextSize(sizeButtonsText);
        button_minus.setTextSize(sizeButtonsText);
        button_plus.setTextSize(sizeButtonsText);
        button_period.setTextSize(sizeButtonsText);
        button_equals.setTextSize(sizeButtonsText);
        button_percent.setTextSize(sizeButtonsText);
    }

    @Override
    public void onClick(View v) {
        editTextIfValueIsError();
        editTextIfContainsPoint();
        getDoubleValueOfEditText();
        switch (v.getId()) {
            case R.id.button_number_0:
                onClickButtonNumber0();
                break;
            case R.id.button_number_1:
                onClickButtonNumberFrom1To9(button_number_1);
                break;
            case R.id.button_number_2:
                onClickButtonNumberFrom1To9(button_number_2);
                break;
            case R.id.button_number_3:
                onClickButtonNumberFrom1To9(button_number_3);
                break;
            case R.id.button_number_4:
                onClickButtonNumberFrom1To9(button_number_4);
                break;
            case R.id.button_number_5:
                onClickButtonNumberFrom1To9(button_number_5);
                break;
            case R.id.button_number_6:
                onClickButtonNumberFrom1To9(button_number_6);
                break;
            case R.id.button_number_7:
                onClickButtonNumberFrom1To9(button_number_7);
                break;
            case R.id.button_number_8:
                onClickButtonNumberFrom1To9(button_number_8);
                break;
            case R.id.button_number_9:
                onClickButtonNumberFrom1To9(button_number_9);
                break;
            case R.id.button_c:
                onClickButtonC();
                break;
            case R.id.button_plus_minus:
                onClickButtonPlusMinus();
                break;
            case R.id.button_division:
                onClickButtonDivision();
                break;
            case R.id.button_backspace:
                onClickButtonBackspace();
                break;
            case R.id.button_multiplication:
                onClickButtonMultiplication();
                break;
            case R.id.button_minus:
                onClickButtonMinus();
                break;
            case R.id.button_plus:
                onClickButtonPlus();
                break;
            case R.id.button_period:
                onClickButtonPeriod();
                break;
            case R.id.button_equals:
                onClickButtonEquals();
                break;
            case R.id.button_percent:
                onClickButtonPercent();
                break;
            default:
                break;
        }
    }

    private void onClickButtonNumber0() {
        if (isOperand2WaitFirstInput) {
            editTextSetText(button_number_0);
            isOperand2WaitFirstInput = false;
        } else if (isFinalResult) {
            editTextSetText(button_number_0);
            isFinalResult = false;
        } else if (editTextContainsPoint) {
            editTextAppend(button_number_0);
        } else if (editTextEqualsError) {
            editTextSetText(button_number_0);
        } else if (valueOfEditText > ZERO_INT ||
                valueOfEditText < ZERO_INT) {
            editTextAppend(button_number_0);
        }
        setValueForButtonPressed();
    }

    private void onClickButtonNumberFrom1To9(Button buttonNumberFrom1To9) {
        if (isOperand2WaitFirstInput) {
            editTextSetText(buttonNumberFrom1To9);
            isOperand2WaitFirstInput = false;
        } else if (isFinalResult) {
            editTextSetText(buttonNumberFrom1To9);
            isFinalResult = false;
        } else if (editTextContainsPoint) {
            editTextAppend(buttonNumberFrom1To9);
        } else if (valueOfEditText == ZERO_INT) {
            editTextSetText(buttonNumberFrom1To9);
        } else {
            editTextAppend(buttonNumberFrom1To9);
        }
        setValueForButtonPressed();
    }

    private void onClickButtonC() {
        editTextSetTextZero();
        resetValue();
    }

    private void onClickButtonPlusMinus() {
        if (!editTextEqualsError) {
            if (editText.getText().toString().startsWith(MINUS)) {
                editText.setText(editText.getText().replace(ZERO_INT, ONE_INT, EMPTY));
            } else {
                editText.setText(MINUS.concat(editText.getText().toString()));
            }
        }
        setValueForButtonPressed();
    }

    private void onClickButtonDivision() {
        activateOnClickEquals();
        if (!editTextEqualsError) {
            if (!(editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && operation.equals(EMPTY)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult)
                    || !(editText.getText().toString().equals(MINUS.concat(getString(R.string.zero)))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult)) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(DIVISION);
            }
        }
    }

    private void onClickButtonBackspace() {
        if (!editTextEqualsError) {
            if (!editText.getText().toString().contains(E)) {
                if (!isFinalResult) {
                    if (editText.getText().length() > TWO_INT) {
                        editText.setText(editText.getText()
                                .subSequence(ZERO_INT, editText.getText().length() - ONE_INT));
                    } else if (editText.getText().length() == TWO_INT &&
                            valueOfEditText > ZERO_INT) {
                        editText.setText(editText.getText()
                                .subSequence(ZERO_INT, editText.getText().length() - ONE_INT));
                    } else if ((editText.getText().length() == ONE_INT &&
                            valueOfEditText > ZERO_INT)) {
                        editTextSetTextZero();
                    } else if ((editText.getText().length() == TWO_INT &&
                            valueOfEditText < ZERO_INT)) {
                        editTextSetTextZero();
                    } else if (editText.getText().toString()
                            .equals(MINUS.concat(getString(R.string.zero)))) {
                        editTextSetTextZero();
                    } else if (editText.getText().toString()
                            .equals(getString(R.string.zero).concat(getString(R.string.point)))) {
                        editTextSetTextZero();
                    }
                }
            }
        }
        setValueForButtonPressed();
    }

    private void onClickButtonMultiplication() {
        activateOnClickEquals();
        if (!editTextEqualsError) {
            if (!(editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult)) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(MULTIPLICATION);
            }
            if (editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(MULTIPLICATION);
            }
        }
    }

    private void onClickButtonMinus() {
        activateOnClickEquals();
        if (!editTextEqualsError) {
            if (!(editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult)) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(MINUS);
            }
            if (editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(MINUS);
            }
        }
    }

    private void onClickButtonPlus() {
        activateOnClickEquals();
        if (!editTextEqualsError) {
            if (!(editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult)) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(PLUS);
            }
            if (editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult) {
                newBigDecimal();
                setValuesToBooleanVariables();
                setValuesToOperations(PLUS);
            }
        }
    }

    private void onClickButtonPeriod() {
        if (!editTextEqualsError) {
            if (isOperand2WaitFirstInput) {
                if (!editTextContainsPoint) {
                    editText.append(getString(R.string.point));
                    isOperand2WaitFirstInput = false;
                    setValueForButtonPressed();
                }
            } else if (isFinalResult) {
                if (!editTextContainsPoint) {
                    editText.setText(getString(R.string.zero).concat(getString(R.string.point)));
                    isFinalResult = false;
                    setValueForButtonPressed();
                }
            } else if (!editTextContainsPoint) {
                editText.append(getString(R.string.point));
            }
        } else {
            editText.setText("0.");
            resetValue();
        }
    }

    private void onClickButtonEquals() {
        if (!editTextEqualsError) {
            if (isOperand1AlreadyFilled && operationEquals.equals(EMPTY)) {
                BigDecimal bd = new BigDecimal(editText.getText().toString());
                bigDecimalEqualsOperand2 = new BigDecimal(editText.getText().toString());
                operationEquals = EQUAL;
                switch (operation) {
                    case PLUS:
                        bigDecimal = bigDecimal.add(bd);
                        setEditTextAndBooleanValuesAndPreviousOperation(PLUS);
                        break;
                    case MINUS:
                        bigDecimal = bigDecimal.subtract(bd);
                        setEditTextAndBooleanValuesAndPreviousOperation(MINUS);
                        break;
                    case MULTIPLICATION:
                        bigDecimal = bigDecimal.multiply(bd);
                        setEditTextAndBooleanValuesAndPreviousOperation(MULTIPLICATION);
                        break;
                    case DIVISION:
                        if (valueOfEditText != ZERO_INT) {
                            bigDecimal = bigDecimal
                                    .divide(bd, SCALE_INT, BigDecimal.ROUND_HALF_UP);
                            setEditTextAndBooleanValuesAndPreviousOperation(DIVISION);
                        } else {
                            editTextSetTextError();
                        }
                        break;
                    default:
                        break;
                }
            } else if (operationEquals.equals(EQUAL)) {
                if (isButtonPressed){
                    bigDecimal = new BigDecimal(editText.getText().toString());
                }
                switch (operationPrevious) {
                    case PLUS:
                        if (operationTemporaryPercent.equals(PERCENT)) {
                            bigDecimal = bigDecimal.add(bigDecimalTemporaryPercent);
                        } else {
                            bigDecimal = bigDecimal.add(bigDecimalEqualsOperand2);
                        }
                        setEditTextAndBooleanValues();
                        break;
                    case MINUS:
                        if (operationTemporaryPercent.equals(PERCENT)) {
                            bigDecimal = bigDecimal.subtract(bigDecimalTemporaryPercent);
                        } else {
                            bigDecimal = bigDecimal.subtract(bigDecimalEqualsOperand2);
                        }
                        setEditTextAndBooleanValues();
                        break;
                    case MULTIPLICATION:
                        if (operationTemporaryPercent.equals(PERCENT)) {
                            bigDecimal = bigDecimal.multiply(bigDecimalTemporaryPercent);
                        } else {
                            bigDecimal = bigDecimal.multiply(bigDecimalEqualsOperand2);
                        }
                        setEditTextAndBooleanValues();
                        break;
                    case DIVISION:
                        if (valueOfEditText != ZERO_INT) {
                            if (operationTemporaryPercent.equals(PERCENT)) {
                                if (!bigDecimalTemporaryPercent.equals(bigDecimalZero)) {
                                    bigDecimal = bigDecimal
                                            .divide(bigDecimalTemporaryPercent,
                                                    SCALE_INT, RoundingMode.HALF_UP);
                                } else {
                                    editTextSetTextError();
                                }
                            } else {
                                if (!bigDecimalEqualsOperand2.equals(bigDecimalZero)) {
                                    bigDecimal = bigDecimal.divide(bigDecimalEqualsOperand2,
                                            SCALE_INT, BigDecimal.ROUND_HALF_UP);
                                } else {
                                    editTextSetTextError();
                                }
                            }
                            setEditTextAndBooleanValues();
                            break;
                        }
                        break;
                    default:
                        break;
                }
                operationTemporaryPercent = EMPTY;
            }
        }
        isButtonPressed = false;
    }

    private void onClickButtonPercent() {
        if (!editTextEqualsError) {
            BigDecimal bd = new BigDecimal(editText.getText().toString());
            BigDecimal bdOneHundredPercent = new BigDecimal(String.valueOf(ONE_HUNDRED_PERCENT));
            BigDecimal bdDivide = bd.divide(bdOneHundredPercent, SCALE_INT, RoundingMode.HALF_UP);
            if (!(editText.getText().toString().equals(getString(R.string.zero))
                    && bigDecimal.equals(bigDecimalZero)
                    && operation.equals(EMPTY)
                    && !isOperand1AlreadyFilled
                    && !isOperand2WaitFirstInput
                    && !isFinalResult)) {
                switch (operation) {
                    case EMPTY:
                        bigDecimal = bdDivide;
                        setEditTextAndBooleanValues();
                        break;
                    case MULTIPLICATION:
                        bigDecimalTemporaryPercent = bdDivide;
                        setOperationPercent(MULTIPLICATION);
                        break;
                    case PLUS:
                        bigDecimalTemporaryPercent = bigDecimal
                                .multiply(bd)
                                .divide(bdOneHundredPercent,
                                        SCALE_INT, RoundingMode.HALF_UP);
                        setOperationPercent(PLUS);
                        break;
                    case MINUS:
                        bigDecimalTemporaryPercent = bigDecimal
                                .multiply(bd)
                                .divide(bdOneHundredPercent,
                                        SCALE_INT, RoundingMode.HALF_UP);
                        setOperationPercent(MINUS);
                        break;
                    case DIVISION:
                        if (Double.parseDouble(editText.getText().toString()) != ZERO_INT) {
                            bigDecimalTemporaryPercent = (new BigDecimal(editText.getText().toString()))
                                    .multiply(new BigDecimal("0.01"));
                            setOperationPercent(DIVISION);
                        } else {
                            editTextSetTextError();
                        }
                        break;
                }
            }
        }
    }

    private void setOperationPercent(String operation) {
        operationTemporaryPercent = PERCENT;
        operationPrevious = operation;
        editTextSetTextBigDecimal(bigDecimalTemporaryPercent);
    }

    private void setValuesToBooleanVariablesForPercentAndEqualsButtons() {
        isOperand1AlreadyFilled = false;
        isOperand2WaitFirstInput = false;
        isFinalResult = true;
        operation = EMPTY;
    }

    private void setValuesToBooleanVariables() {
        isOperand1AlreadyFilled = true;
        isOperand2WaitFirstInput = true;
        isFinalResult = false;
    }

    private void setResultToEditText1(BigDecimal bigDecimal, int scale, int counter) {
        editText.setText(String.valueOf(new BigDecimal(String.valueOf((bigDecimal
                .setScale(scale, BigDecimal.ROUND_HALF_UP))
                .stripTrailingZeros()
                .toPlainString())))
                .concat(E)
                .concat(String.valueOf(counter)));
    }

    private void setResultToEditText2(BigDecimal bigDecimal, int scale) {
        editText.setText(bigDecimal
                .setScale(scale, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toPlainString());
    }

    private void editTextSetTextError() {
        editText.setText(getString(R.string.error));
        resetValue();
    }

    private void editTextSetTextZero() {
        editText.setText(getString(R.string.zero));
    }

    private void editTextSetText(Button button) {
        editText.setText(button.getText().toString());
    }

    private void editTextAppend(Button button) {
        editText.append(button.getText().toString());
    }

    private void editTextIfContainsPoint() {
        if (editText.getText().toString().contains(getString(R.string.point))) {
            editTextContainsPoint = true;
        } else if (!editText.getText().toString().contains(getString(R.string.point))) {
            editTextContainsPoint = false;
        }
    }

    private void getDoubleValueOfEditText() {
        if (!editTextEqualsError) {
            valueOfEditText = Double.parseDouble(editText.getText().toString());
        }
    }

    private void editTextIfValueIsError() {
        if (editText.getText().toString().equals(getString(R.string.error))) {
            editTextEqualsError = true;
        } else if (!editText.getText().toString().equals(getString(R.string.error))) {
            editTextEqualsError = false;
        }
    }

    private void newBigDecimal() {
        bigDecimal = new BigDecimal(editText.getText().toString());
    }

    private void setEditTextAndBooleanValuesAndPreviousOperation(String operation) {
        setEditTextAndBooleanValues();
        operationPrevious = operation;
    }

    private void setEditTextAndBooleanValues() {
        editTextSetTextBigDecimal(bigDecimal);
        setValuesToBooleanVariablesForPercentAndEqualsButtons();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            vibrator.vibrate(VIBRATE_SECONDS);
        }
        return false;
    }

    private void setValuesToOperations(String operationStr) {
        operation = operationStr;
        operationPrevious = operationStr;
        operationEquals = EMPTY;
    }

    private void editTextSetTextBigDecimal(BigDecimal bigDecimal) {
        int counter = ZERO_INT;
        BigDecimal bigDecimalTemporary = new BigDecimal(String.valueOf(bigDecimal));
        if (bigDecimalTemporary.compareTo(new BigDecimal(getString(R.string.zero))) > ZERO_INT) {
            if (bigDecimalTemporary.compareTo(new BigDecimal("99999999")) > ZERO_INT) {
                while (bigDecimalTemporary.compareTo(new BigDecimal("9")) > ZERO_INT) {
                    bigDecimalTemporary = bigDecimalTemporary.multiply(new BigDecimal("0.1"));
                    counter++;
                }
                if (counter < 10) {
                    setResultToEditText1(bigDecimalTemporary, 3, counter);
                } else if (counter < 100) {
                    setResultToEditText1(bigDecimalTemporary, 2, counter);
                } else if (counter < 200) {
                    setResultToEditText1(bigDecimalTemporary, 1, counter);
                } else {
                    editTextSetTextError();
                }
            } else if (bigDecimalTemporary.compareTo(new BigDecimal("0.001")) < ZERO_INT) {
                while (bigDecimalTemporary.compareTo(new BigDecimal("1")) < ZERO_INT) {
                    bigDecimalTemporary = bigDecimalTemporary.multiply(new BigDecimal("10"));
                    counter--;
                }
                if (counter > -10) {
                    setResultToEditText1(bigDecimalTemporary, 2, counter);
                } else if (counter > -100) {
                    setResultToEditText1(bigDecimalTemporary, 1, counter);
                } else if (counter > -200) {
                    setResultToEditText1(bigDecimalTemporary, 0, counter);
                } else {
                    editTextSetTextError();
                }
            } else {
                if (bigDecimalTemporary.compareTo(new BigDecimal("1000000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 0);
                } else if (bigDecimalTemporary.compareTo(new BigDecimal("100000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 1);
                } else if (bigDecimalTemporary.compareTo(new BigDecimal("10000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 2);
                } else if (bigDecimalTemporary.compareTo(new BigDecimal("1000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 3);
                } else if (bigDecimalTemporary.compareTo(new BigDecimal("100")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 4);
                } else if (bigDecimalTemporary.compareTo(new BigDecimal("10")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 5);
                } else if (bigDecimalTemporary.compareTo(new BigDecimal("0.0000001")) >= ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 6);
                }
            }
        } else if (bigDecimalTemporary.compareTo(new BigDecimal(getString(R.string.zero))) < ZERO_INT) {
            if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                    .compareTo(new BigDecimal("99999999")) > ZERO_INT) {
                while (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("9")) > ZERO_INT) {
                    bigDecimalTemporary = bigDecimalTemporary.multiply(new BigDecimal("0.1"));
                    counter++;
                }
                if (counter < 10) {
                    setResultToEditText1(bigDecimalTemporary, 4, counter);
                } else if (counter < 100) {
                    setResultToEditText1(bigDecimalTemporary, 3, counter);
                } else if (counter < 200) {
                    setResultToEditText1(bigDecimalTemporary, 2, counter);
                } else {
                    editTextSetTextError();
                }
            } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                    .compareTo(new BigDecimal("0.01")) < ZERO_INT) {
                while (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("1")) < ZERO_INT) {
                    bigDecimalTemporary = bigDecimalTemporary.multiply(new BigDecimal("10"));
                    counter--;
                }
                if (counter > -10) {
                    setResultToEditText1(bigDecimalTemporary, 3, counter);
                } else if (counter > -100) {
                    setResultToEditText1(bigDecimalTemporary, 2, counter);
                } else if (counter > -200) {
                    setResultToEditText1(bigDecimalTemporary, 1, counter);
                } else {
                    editTextSetTextError();
                }
            } else {
                if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("1000000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 0);
                } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("100000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 1);
                } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("10000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 2);
                } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("1000")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 3);
                } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("100")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 4);
                } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("10")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 5);
                } else if (((new BigDecimal("-1")).multiply(bigDecimalTemporary))
                        .compareTo(new BigDecimal("0")) > ZERO_INT) {
                    setResultToEditText2(bigDecimalTemporary, 6);
                }
            }
        } else if (bigDecimalTemporary.compareTo(new BigDecimal(getString(R.string.zero))) == ZERO_INT) {
            editText.setText(getString(R.string.zero));
        }
    }
}
