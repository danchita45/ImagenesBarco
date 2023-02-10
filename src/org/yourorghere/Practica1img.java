package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Practica1img.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Practica1img implements GLEventListener {

    public static GLCanvas canvas = new GLCanvas();

    public static int bnd = 0;
    private static final JMenuBar jmenubar = new JMenuBar();
    public static final JMenu MOriginal = new JMenu();
    public static final JMenu MOTranslation = new JMenu();
    public static final JMenu MSoundOf = new JMenu();
    public static final JMenu MSoundON = new JMenu();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple JOGL Application");
        MOriginal.setText("Original");
        jmenubar.add(MOriginal);

        MOTranslation.setText("Traslacion");
        jmenubar.add(MOTranslation);

        MSoundON.setText("Sonido ON");
        jmenubar.add(MSoundON);

        MSoundOf.setText("Sonido OFF");
        jmenubar.add(MSoundOf);

        MOriginal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                MOriginalMouseClicked(e);
            }

        });

        MOTranslation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                MOTMouseClicked(e);
            }

        });

        MSoundOf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                MSOFMouseClicked(e);
            }

        });

        MSoundON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                MSONMouseClicked(e);
            }

        });

        frame.setJMenuBar(jmenubar);

        canvas.addGLEventListener(new Practica1img());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-8.0, 8.0, -8.0, 8.0);
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        if (bnd == 1) {
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.1f, 0.4f, 0.1f);
            gl.glVertex2f(12f, 4f);
            gl.glVertex2f(0f, 4f);
            gl.glVertex2f(3f, 1f);
            gl.glVertex2f(9f, 1f);
            gl.glEnd();
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.7f, 0.7f, 0.1f);
            gl.glVertex2f(5.3f, 12f);
            gl.glColor3f(0.9f, 0.9f, 0.1f);
            gl.glVertex2f(5f, 12f);
            gl.glVertex2f(5f, 4f);
            gl.glVertex2f(5.3f, 4f);
            gl.glEnd();

            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.0f, 0.0f, 0.9f);
            gl.glVertex2f(5.5f, 12f);
            gl.glColor3f(0.9f, 0.9f, 0.1f);
            gl.glVertex2f(5.5f, 4.3f);
            gl.glVertex2f(12f, 4.3f);
            gl.glEnd();

            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.0f, 0.0f, 0.9f);
            gl.glVertex2f(4.8f, 11f);
            gl.glColor3f(0.9f, 0.9f, 0.1f);
            gl.glVertex2f(4.8f, 4.3f);
            gl.glVertex2f(0, 4.3f);
            gl.glEnd();

            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.0f, 0.0f, 0.9f);
            gl.glVertex2f(4.8f, 12f);
            gl.glColor3f(0.1f, 0.9f, 0.9f);
            gl.glVertex2f(4.8f, 11f);
            gl.glVertex2f(2, 12f);
            gl.glEnd();
        } else {

        }

        //base trasladada
        Transformaciones2d tf2d = new Transformaciones2d();

        if (bnd == 2) {
            float ot[][] = tf2d.mTraslacion(12, 4, 0, 4, 3, 1, 9, 1);
            gl.glBegin(GL.GL_POLYGON);
            gl.glVertex2f(ot[0][0], ot[0][1]);
            gl.glVertex2f(ot[1][0], ot[1][1]);
            gl.glVertex2f(ot[2][0], ot[2][1]);
            gl.glVertex2f(ot[3][0], ot[3][1]);
            gl.glEnd();

            float mt[][] = tf2d.mTraslacion(5.3, 12, 5, 12, 5, 4, 5.3, 4);
            gl.glBegin(GL.GL_POLYGON);
            gl.glVertex2f(mt[0][0], mt[0][1]);
            gl.glVertex2f(mt[1][0], mt[1][1]);
            gl.glVertex2f(mt[2][0], mt[2][1]);
            gl.glVertex2f(mt[3][0], mt[3][1]);
            gl.glEnd();
            float bdd[][] = tf2d.mTraslacion(5.5, 12, 5.5, 4.3, 12, 4.3, 0, 0);
            gl.glBegin(GL.GL_POLYGON);
            gl.glVertex2f(bdd[0][0], bdd[0][1]);
            gl.glVertex2f(bdd[1][0], bdd[1][1]);
            gl.glVertex2f(bdd[2][0], bdd[2][1]);
            gl.glEnd();

            float bdi[][] = tf2d.mTraslacion(4.8, 11, 4.8, 4.3, 0, 4.3, 0, 0);
            gl.glBegin(GL.GL_POLYGON);
            gl.glVertex2f(bdi[0][0], bdi[0][1]);
            gl.glVertex2f(bdi[1][0], bdi[1][1]);
            gl.glVertex2f(bdi[2][0], bdi[2][1]);
            gl.glEnd();

            float bd[][] = tf2d.mTraslacion(4.8, 12, 4.8, 11, 2, 12, 0, 0);
            gl.glBegin(GL.GL_POLYGON);
            gl.glVertex2f(bd[0][0], bd[0][1]);
            gl.glVertex2f(bd[1][0], bd[1][1]);
            gl.glVertex2f(bd[2][0], bd[2][1]);
            gl.glEnd();
        }

        //texto 
        TextRenderer txt = new TextRenderer(new Font("Arial", Font.BOLD, 12));
        txt.beginRendering(300, 300);
        txt.setColor(Color.BLUE);
        txt.draw("velero", 15, 15);
        txt.endRendering();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public static void MOriginalMouseClicked(MouseEvent e) {
        bnd = 1;
    }

    public static void MOTMouseClicked(MouseEvent e) {
        bnd = 2;
        canvas.repaint();//To change body of generated methods, choose Tools | Templates.

    }

    public static void MSOFMouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void MSONMouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
