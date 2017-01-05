package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by erikdejesus on 7/16/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    /**
    A custom constructor for the WordAdapter that takes in two parameters and punts
    contructor functions to the super class
    Params:
    @param: context = the activity this is used in
    @param:  = the ArrayList of type Word to be passed into the list_item view
     */
    public WordAdapter (Activity context, ArrayList<Word> words, int ColorResourceId){
        super(context, 0, words);
        mColorResourceId= ColorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the words from the Array Adapter
        final Word currentWord = getItem(position);

        //Grab the LinearLayout containing the text views and set it's color to the color based into the constructor
        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);


        //find the color that the id maps too
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);


        //Retrieve the two text views for the miwork and english words
        TextView miworkWord = (TextView) listItemView.findViewById(R.id.miwork_word);
        TextView defaultWord = (TextView) listItemView.findViewById(R.id.english_word);


        //Set the TextVies to be equal to their miwork and english translations
        miworkWord.setText(currentWord.getMiwokTranslation());
        defaultWord.setText(currentWord.getDefaultTranslation());


            //retrieve the Image view for the corresponding word and set its image
            ImageView wordImage = (ImageView) listItemView.findViewById(R.id.image);

        //check and see if the there is an image by making sure a resource ID exists. 
        if(currentWord.getImageResourceId() > 0) {
            //This could also be if(currentWord.hasImage()) if I need to use the constant value later.
            wordImage.setImageResource(currentWord.getImageResourceId());
            wordImage.setVisibility(View.VISIBLE);
        } else {

            //hide the view and remove it from the layout if there are no images
            wordImage.setVisibility(View.GONE);
        }

        //Return the entire listItemView containing the two TextViews
        return listItemView;
    }
}
