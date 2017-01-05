package com.example.android.miwok;

/**
 * Represents a pair of vocabulary words: An english default version and a miwok translation
 */
public class Word {

    //English word
    private String mEnglish;
    //the miWok translation of a word
    private String mMiwok;
    //The resource ID for a an image associated with a word
    private int mImageResourceId = -1;
    private int mAudioResourceId = -1;

    // Constant value that represents no image was provided for this word.
    // private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object wth strings only.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word (String defaultTranslation, String miwokTranslation, int AudioResourceId){
        mEnglish = defaultTranslation;
        mMiwok = miwokTranslation;
        mAudioResourceId =  AudioResourceId;

    }

    /**
     * Create a new Word object with Images
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param ImageResourceId is R.drawable id for the image assocaited with the word
     */
    public Word (String defaultTranslation, String miwokTranslation, int ImageResourceId, int AudioResourceId){
        mEnglish = defaultTranslation;
        mMiwok = miwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
    }

    //returns the english tranlsation of a word
    public String getDefaultTranslation () {
        return mEnglish;
    }

    //retursn the miwok translation of a word
    public String getMiwokTranslation () {
        return mMiwok;
    }

    //returns the resource id for the image associated with the word
    public int getImageResourceId () {return mImageResourceId;}

    //return the audio resoruce id
    public int getAudioResourceId () {return  mAudioResourceId;}

    //Returns whether or not there is an image for this word. This is removed for the time being
//    public boolean hasImage() {
//        return mImageResourceId != NO_IMAGE_PROVIDED;
//    }

}
