package com.malaysianmannheim.baca.castle1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.malaysianmannheim.baca.Castle1Activity;
import com.malaysianmannheim.baca.R;

public class crown1FITB extends AppCompatActivity implements View.OnDragListener, View.OnTouchListener {

    private static final String TAG = crown1FITB.class.getSimpleName();
    public static int marksCrown1game1;

    private TextView item1TxtV, item2TxtV, item3TxtV, item4TxtV, letter1TxtV, letter2TxtV, letter3TxtV, letter4TxtV;
    private TextView drop1, drop2, drop3, drop4, markTxtV;
    private ImageView item1ImgV, item2ImgV, item3ImgV, item4ImgV;
    public ImageView castle1Button, nextButtonImgV, tryAgainBtn, nextButtonImgV2;
    RelativeLayout resultRL;
    //public int marksCrown1game1;
    int turns=0;
    Boolean isCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crown1fitb);
        StatusBarUtil.setTransparent(this);

        marksCrown1game1 = 0;
        //marks page and button
        resultRL = findViewById(R.id.resultLayout);
        resultRL.setVisibility(View.INVISIBLE);
        nextButtonImgV2 = findViewById(R.id.nextButton2ImgView);
        tryAgainBtn = findViewById(R.id.tryAgainButtonImageView);
        markTxtV = findViewById(R.id.markTextView);

        //item 1
        item1TxtV = findViewById(R.id.crown1Item1TextView);
        item1ImgV = findViewById(R.id.item1Crown1ImageView);
        letter1TxtV = findViewById(R.id.letter1Crown1);
        //item 2
        item2TxtV = findViewById(R.id.crown1Item2TextView);
        item2ImgV = findViewById(R.id.item2Crown1ImageView);
        letter2TxtV = findViewById(R.id.letter2Crown1);
        //item 3
        item3TxtV = findViewById(R.id.crown1Item3TextView);
        item3ImgV = findViewById(R.id.item3Crown1ImageView);
        letter3TxtV = findViewById(R.id.letter3Crown1);
        //item 4
        item4TxtV = findViewById(R.id.crown1Item4TextView);
        item4ImgV = findViewById(R.id.item4Crown1ImageView);
        letter4TxtV = findViewById(R.id.letter4Crown1);
        
        drop1 = findViewById(R.id.dropItem1);
        drop2 = findViewById(R.id.dropItem2);
        drop3 = findViewById(R.id.dropItem3);
        drop4 = findViewById(R.id.dropItem4);

        //back to Castle 1 activity
        castle1Button = (ImageView) findViewById(R.id.castle1ButtonImageView);
        castle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crown1FITB.this, Castle1Activity.class);
                startActivity(intent);
            }
        });

        nextButtonImgV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(crown1FITB.this, Castle1Activity.class);
               startActivity(intent);

            }
        });

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(crown1FITB.this, crown1FITB.class);
                startActivity(intent);

            }
        });


        letter1TxtV.setOnTouchListener((View.OnTouchListener) this);
        letter2TxtV.setOnTouchListener((View.OnTouchListener) this);
        letter3TxtV.setOnTouchListener(this);
        letter4TxtV.setOnTouchListener((View.OnTouchListener) this);

        drop1.setOnDragListener((View.OnDragListener) this);
        drop2.setOnDragListener((View.OnDragListener) this);
        drop3.setOnDragListener((View.OnDragListener) this);
        drop4.setOnDragListener((View.OnDragListener) this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (event.getAction()==MotionEvent.ACTION_DOWN)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        }
        else return false;

    }

    @Override
    public boolean onDrag(View v, DragEvent event)
    {
        //handle the dragged view being dropped over a target view
        TextView dropped = (TextView)event.getLocalState();
        TextView dropTarget = (TextView) v;

        switch (event.getAction())
        {

            case DragEvent.ACTION_DRAG_ENTERED:

                // Apply a gray tint to the View
                //dropTarget.setVisibility(View.VISIBLE);
                //dropTarget.setTextColor(Color.LTGRAY);

                // Invalidate the view to force a redraw in the new tint
                //v.invalidate();

                return true;
            case DragEvent.ACTION_DROP:
                if (turns < 4) {
                    //stop displaying the view where it was before it was dragged
                    dropped.setVisibility(View.INVISIBLE);
                    //if an item has already been dropped here, there will be different string
                    String text = dropTarget.getText().toString();
                    if (text.equals(letter1TxtV.getText().toString()))
                        letter1TxtV.setVisibility(View.VISIBLE);
                    else if (text.equals(letter2TxtV.getText().toString()))
                        letter2TxtV.setVisibility(View.VISIBLE);
                    else if (text.equals(letter3TxtV.getText().toString()))
                        letter3TxtV.setVisibility(View.VISIBLE);
                    else if (text.equals(letter4TxtV.getText().toString()))
                        letter4TxtV.setVisibility(View.VISIBLE);

                    dropTarget.setText(dropped.getText());
                    dropTarget.setTextColor(Color.RED);
                    isCorrect = true;
                    //update the text and color in the target view to reflect the data being dropped
                    //true = white, false = red
                    if (drop1.getText().toString().equals("A") && dropped.getText().toString().equals("A")) {

                        drop1.setTextColor(Color.WHITE);
                        Toast.makeText(crown1FITB.this, "Bingo! A", Toast.LENGTH_SHORT).show();
                        marksCrown1game1 += 1;
                        //dropped.setText("");

                    } else if (drop2.getText().toString().equals("B") && dropped.getText().toString().equals("B")) {

                        drop2.setTextColor(Color.WHITE);
                        Toast.makeText(crown1FITB.this, "Bingo! B", Toast.LENGTH_SHORT).show();
                        marksCrown1game1 += 1;
                        //dropped.setText("");

                    } else if (drop3.getText().toString().equals("C") && dropped.getText().toString().equals("C")) {

                        drop3.setTextColor(Color.WHITE);
                        Toast.makeText(crown1FITB.this, "Bingo! C", Toast.LENGTH_SHORT).show();
                        marksCrown1game1 += 1;
                        //dropped.setText("");

                    } else if (drop4.getText().toString().equals("D") && dropped.getText().toString().equals("D")) {

                        drop4.setTextColor(Color.WHITE);
                        Toast.makeText(crown1FITB.this, "Bingo! D", Toast.LENGTH_SHORT).show();
                        marksCrown1game1 += 1;
                        //dropped.setText("");

                    } else {
                        isCorrect = false;
                        //displaying the view where it was before it was dragged
                        Toast.makeText(crown1FITB.this, "Opps, try another letter!", Toast.LENGTH_SHORT).show();
                        //if there is already an item here, set it back visible in its original place

                    }


                    turns += 1;
                    Toast.makeText(crown1FITB.this, "turns " + turns, Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    turns+=1;
                    Toast.makeText(crown1FITB.this, "turns " + turns, Toast.LENGTH_SHORT).show();
                    return true;
                }

            case DragEvent.ACTION_DRAG_ENDED:
                if(turns>=4) {
                    String markString = String.valueOf(marksCrown1game1);
                    markTxtV.setText( markString + "/4");
                    castle1Button.setVisibility(View.INVISIBLE);
                    resultRL.setVisibility(View.VISIBLE);
                }
                return  true;

            default:break;
        }
        return true;
        /*Log.d(TAG, "onDrag");

        // Store the action type for the incoming event
        final int action = event.getAction();

        // Handles each of the expected events
        switch (action)
        {
            case DragEvent.ACTION_DRAG_STARTED:

                // In order to inform user that drag has started, we apply yellow tint to view
                ((TextView) v).setVisibility(View.INVISIBLE);

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();

                // Returns true to indicate that the View can accept the
                // dragged data.
                return true;

            case DragEvent.ACTION_DRAG_ENTERED:

                // Apply a gray tint to the View
                ((TextView) v).setVisibility(View.VISIBLE);
                ((TextView) v).setTextColor(Color.LTGRAY);

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();

                return true;

            case DragEvent.ACTION_DRAG_LOCATION:

                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                // Re-sets the color tint to yellow
                ((TextView) v).setVisibility(View.INVISIBLE);
                ((TextView) v).setTextColor(Color.YELLOW);

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();

                return true;

            case DragEvent.ACTION_DROP:

                // Gets the item containing the dragged data
                ClipData dragData = event.getClipData();

                // Gets the text data from the item.
                final String tag = dragData.getItemAt(0).getText().toString();

                // Displays a message containing the dragged data.
                Toast.makeText(crown1FITB.this, "The dragged image is " + tag, Toast.LENGTH_SHORT).show();

                // Turns off any color tints
                ((TextView) v).setVisibility(View.INVISIBLE);
                //((TextView) v).setTextColor(Color.WHITE);

                // Invalidates the view to force a redraw
                v.invalidate();

                return true;

            case DragEvent.ACTION_DRAG_ENDED:

                // Turns off any color tinting
                ((TextView) v).setVisibility(View.VISIBLE);
                ((TextView) v).setTextColor(Color.WHITE);

                // Invalidates the view to force a redraw
                v.invalidate();
                String vString = ((TextView) v).getText().toString();
                // Check for result
                if (event.getResult())
                {
                    Toast.makeText(crown1FITB.this, "Bingo !", Toast.LENGTH_SHORT).show();
                    if (vString.equals(letter1TxtV))
                    {
                        //Toast.makeText(crown1FITB.this, "Bingo !", Toast.LENGTH_SHORT).show();
                        letter1TxtV.setVisibility(View.INVISIBLE);
                    }
                    else if (vString.equals(letter2TxtV))
                    {
                        //Toast.makeText(crown1FITB.this, "Bingo !", Toast.LENGTH_SHORT).show();
                        letter2TxtV.setVisibility(View.INVISIBLE);
                    }
                    else if (vString.equals(letter3TxtV))
                    {
                        //Toast.makeText(crown1FITB.this, "Bingo !", Toast.LENGTH_SHORT).show();
                        letter3TxtV.setVisibility(View.INVISIBLE);
                    }

                }
                else
                {
                    Toast.makeText(crown1FITB.this, "Oups, try again !", Toast.LENGTH_SHORT).show();
                    drop1.setText(null);
                    drop2.setText(null);
                }

                return true;

            default:
                break;
        }

        return false;*/
    }

}