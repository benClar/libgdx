package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Application extends ApplicationAdapter {
    private Stage stage;
    private Label outputLabel;

    @Override
    public void create () {
//        Sound mp3Sound = Gdx.audio.newSound(Gdx.files.internal("sound/tick.mp3"));
        Sound mp3Sound = Gdx.audio.newSound(Gdx.files.external("Download/tick.mp3"));
        simpleSound(mp3Sound);
    }

    private void simpleButton() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        int Help_Guides = 12;
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Label title = new Label("Buttons with Skins",mySkin,"big-black");
        title.setSize(Gdx.graphics.getWidth(),row_height*2);
        title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
        title.setAlignment(Align.center);
        stage.addActor(title);

        // Button
        Button button1 = new Button(mySkin,"small");
        button1.setSize(col_width*4,row_height);
        button1.setPosition(col_width,Gdx.graphics.getHeight()-row_height*3);
        button1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Pressed Button");
                return true;
            }
        });
        stage.addActor(button1);

        // Text Button
        Button button2 = new TextButton("Text Button",mySkin,"small");
        button2.setSize(col_width*4,row_height);
        button2.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        button2.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Pressed Text Button");
                return true;
            }
        });
        stage.addActor(button2);

        // ImageButton
        ImageButton button3 = new ImageButton(mySkin);
        button3.setSize(col_width*4,(float)(row_height*2));
        button3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_off.png"))));
        button3.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_on.png"))));
        button3.setPosition(col_width,Gdx.graphics.getHeight()-row_height*6);
        button3.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Pressed Image Button");
                return true;
            }
        });
        stage.addActor(button3);

        //ImageTextButton
        ImageTextButton button4 = new ImageTextButton("ImageText Btn",mySkin,"small");
        button4.setSize(col_width*4,(float)(row_height*2));
        button4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_off.png"))));
        button4.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_on.png"))));
        button4.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*6);
        button4.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Pressed Image Text Button");
                return true;
            }
        });
        stage.addActor(button4);

        outputLabel = new Label("Press a Button",mySkin,"black");
        outputLabel.setSize(Gdx.graphics.getWidth(),row_height);
        outputLabel.setPosition(0,row_height);
        outputLabel.setAlignment(Align.center);
        stage.addActor(outputLabel);
    }

    private void simpleSound(Sound mp3Sound) {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                mp3Sound.play();
            }
        }, 2,1);
    }

    private void simpleText() {
        stage = new Stage(new ScreenViewport());
        int Help_Guides = 12;
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;
        addBackgroundGuide(Help_Guides);

        Label.LabelStyle label1Style = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("bitmapfont/Amble-Regular-26.fnt"));
        label1Style.font = myFont;
        label1Style.fontColor = Color.RED;

        Label label1 = new Label("Title (BitmapFont)",label1Style);
        label1.setSize(Gdx.graphics.getWidth(),row_height);
        label1.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
        label1.setAlignment(Align.center);
        stage.addActor(label1);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("truetypefont/Amble-Light.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        parameter.borderWidth = 1;
        parameter.color = Color.YELLOW;
        parameter.shadowOffsetX = 3;
        parameter.shadowOffsetY = 3;
        parameter.shadowColor = new Color(0, 0.5f, 0, 0.75f);
        BitmapFont font24 = generator.generateFont(parameter); // font size 24 pixels
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font24;

        Label label2 = new Label("True Type Font (.ttf) - Gdx FreeType",labelStyle);
        label2.setSize(Gdx.graphics.getWidth()/Help_Guides*5,row_height);
        label2.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*4);
        stage.addActor(label2);

        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Label label3 = new Label("This is a Label (skin) on  5 columns ",mySkin,"black");
        label3.setSize(Gdx.graphics.getWidth()/Help_Guides,row_height);
        label3.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*6);
        stage.addActor(label3);

        Label label4 = new Label("This is a Label (skin) with a 5 columns width but WITH wrap",mySkin,"black");
        label4.setSize(Gdx.graphics.getWidth()/Help_Guides*5,row_height);
        label4.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*7);
        label4.setWrap(true);
        stage.addActor(label4);
    }

    private void simpleImage() {
        stage = new Stage(new ScreenViewport());
        Texture texture = new Texture(Gdx.files.internal("data/image.jpeg"));
        Image image1 = new Image(texture);
        image1.setPosition(Gdx.graphics.getWidth()/3-image1.getWidth()/2,Gdx.graphics.getHeight()*2/3-image1.getHeight()/2);
        stage.addActor(image1);

        Image image2 = new Image(texture);
        image2.setPosition(Gdx.graphics.getWidth()*2/3-image2.getWidth()/2,Gdx.graphics.getHeight()*2/3-image2.getHeight()/2);
        image2.setOrigin(image2.getWidth()/2,image2.getHeight()/2);
        image2.rotateBy(45);
        stage.addActor(image2);

        Image image3 = new Image(texture);
        image3.setSize(texture.getWidth()/2,texture.getHeight()/2);
        image3.setPosition(Gdx.graphics.getWidth()/3-image3.getWidth()/2,Gdx.graphics.getHeight()/3-image3.getHeight());
        stage.addActor(image3);

        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0,0,texture.getWidth()*8,texture.getHeight()*4);
        Image image4 = new Image(textureRegion);
        image4.setSize(200,100);
        image4.setPosition(Gdx.graphics.getWidth()*2/3-image4.getWidth()/2,Gdx.graphics.getHeight()/3-image4.getHeight());

        stage.addActor(image4);
    }

    public void addBackgroundGuide(int columns){
        Texture texture = new Texture(Gdx.files.internal("background.jpg"));
        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);

        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0,0,texture.getWidth()*columns,texture.getWidth()*columns);
        Image background = new Image(textureRegion);
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getWidth());
        background.setPosition(0,Gdx.graphics.getHeight()-background.getHeight());
        stage.addActor(background);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

}
