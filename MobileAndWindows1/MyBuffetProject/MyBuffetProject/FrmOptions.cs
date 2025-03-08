using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Author: Noah Novales
//Date Created: 10/24/22
//Last Modified By: Noah Novales
//Date Last Modified: 11/15/22
//Assignment: HW Project 2

namespace MyBuffetProject
{
    public partial class FrmOptions : Form
    {
        //booleans to adjust screen with background colors/borders
        bool orange, green, blue, white,
            isCyan = false,
            isYellow = false,
            isPurple = false,
            isIndigo = false,
            isDefault = false;
        public FrmOptions()
        {
            InitializeComponent();
        }

        private void okButton_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            Close();
        }

        //following events are for changing the background
        //must remain visible, so change selected color to black
        //make sure all other colors stay the preview color
        private void defaultButton_CheckedChanged(object sender, EventArgs e)
        {
            BackColor = Color.White;
            defaultButton.ForeColor = Color.Black;
            orangeBtn.ForeColor = Color.Orange;
            greenBtn.ForeColor = Color.Green;
            blueBtn.ForeColor = Color.Blue;

            //following ifs are if border is shown, so keep showing
            if (isYellow)
            {
                Graphics objGraphicsyellow;
                objGraphicsyellow = CreateGraphics();
                objGraphicsyellow.Clear(SystemColors.Control);
                objGraphicsyellow.DrawRectangle(Pens.Yellow, 1, 1, 378, 357);
                objGraphicsyellow.Dispose();
            }
            else if (isPurple)
            {
                Graphics objGraphicsPurple;
                objGraphicsPurple = CreateGraphics();
                objGraphicsPurple.Clear(SystemColors.Control);
                objGraphicsPurple.DrawRectangle(Pens.Purple, 1, 1, 378, 357);
                objGraphicsPurple.Dispose();
            }
            else if (isIndigo)
            {
                Graphics objGraphicsIndigo;
                objGraphicsIndigo = CreateGraphics();
                objGraphicsIndigo.Clear(SystemColors.Control);
                objGraphicsIndigo.DrawRectangle(Pens.Indigo, 1, 1, 378, 357);
                objGraphicsIndigo.Dispose();
            }
            else if (isCyan)
            {
                Graphics objGraphicsCyan;
                objGraphicsCyan = CreateGraphics();
                objGraphicsCyan.Clear(SystemColors.Control);
                objGraphicsCyan.DrawRectangle(Pens.Cyan, 1, 1, 378, 357);
                objGraphicsCyan.Dispose();
            }
            else if (isDefault)
            {
                Graphics objGraphicsDefault;
                objGraphicsDefault = CreateGraphics();
                objGraphicsDefault.Clear(SystemColors.Control);
                objGraphicsDefault.DrawRectangle(Pens.White, 1, 1, 375, 355);
                objGraphicsDefault.Dispose();
            }
            white = true;
            blue = false;
            green = false;
            orange = false;
        }
        //following events are for changing the background
        //must remain visible, so change selected color to black
        //make sure all other colors stay the preview color
        private void orangeBtn_CheckedChanged(object sender, EventArgs e)
        {
            BackColor= Color.Orange;
            defaultButton.ForeColor = Color.White;
            orangeBtn.ForeColor = Color.Black;
            greenBtn.ForeColor = Color.Green;
            blueBtn.ForeColor = Color.Blue;

            //following ifs are if border is shown, so keep showing
            if (isYellow)
            {
                Graphics objGraphicsyellow;
                objGraphicsyellow = CreateGraphics();
                objGraphicsyellow.Clear(SystemColors.Control);
                objGraphicsyellow.DrawRectangle(Pens.Yellow, 1, 1, 378, 357);
                objGraphicsyellow.Dispose();
            }
            else if (isPurple)
            {
                Graphics objGraphicsPurple;
                objGraphicsPurple = CreateGraphics();
                objGraphicsPurple.Clear(SystemColors.Control);
                objGraphicsPurple.DrawRectangle(Pens.Purple, 1, 1, 378, 357);
                objGraphicsPurple.Dispose();
            }
            else if (isIndigo)
            {
                Graphics objGraphicsIndigo;
                objGraphicsIndigo = CreateGraphics();
                objGraphicsIndigo.Clear(SystemColors.Control);
                objGraphicsIndigo.DrawRectangle(Pens.Indigo, 1, 1, 378, 357);
                objGraphicsIndigo.Dispose();
            }
            else if (isCyan)
            {
                Graphics objGraphicsCyan;
                objGraphicsCyan = CreateGraphics();
                objGraphicsCyan.Clear(SystemColors.Control);
                objGraphicsCyan.DrawRectangle(Pens.Cyan, 1, 1, 378, 357);
                objGraphicsCyan.Dispose();
            }
            else if (isDefault)
            {
                Graphics objGraphicsDefault;
                objGraphicsDefault = CreateGraphics();
                objGraphicsDefault.Clear(SystemColors.Control);
                objGraphicsDefault.DrawRectangle(Pens.White, 1, 1, 375, 355);
                objGraphicsDefault.Dispose();
            }

            white = false;
            blue = false;
            green = false;
            orange = true;
        }
        //following events are for changing the background
        //must remain visible, so change selected color to black
        //make sure all other colors stay the preview color
        private void greenBtn_CheckedChanged(object sender, EventArgs e)
        {
            BackColor=Color.Green;
            defaultButton.ForeColor = Color.White;
            orangeBtn.ForeColor = Color.Orange;
            greenBtn.ForeColor = Color.Black;
            blueBtn.ForeColor = Color.Blue;

            //following ifs are if border is shown, so keep showing
            if (isYellow)
            {
                Graphics objGraphicsyellow;
                objGraphicsyellow = CreateGraphics();
                objGraphicsyellow.Clear(SystemColors.Control);
                objGraphicsyellow.DrawRectangle(Pens.Yellow, 1, 1, 378, 357);
                objGraphicsyellow.Dispose();
            }
            else if (isPurple)
            {
                Graphics objGraphicsPurple;
                objGraphicsPurple = CreateGraphics();
                objGraphicsPurple.Clear(SystemColors.Control);
                objGraphicsPurple.DrawRectangle(Pens.Purple, 1, 1, 378, 357);
                objGraphicsPurple.Dispose();
            }
            else if (isIndigo)
            {
                Graphics objGraphicsIndigo;
                objGraphicsIndigo = CreateGraphics();
                objGraphicsIndigo.Clear(SystemColors.Control);
                objGraphicsIndigo.DrawRectangle(Pens.Indigo, 1, 1, 378, 357);
                objGraphicsIndigo.Dispose();
            }
            else if (isCyan)
            {
                Graphics objGraphicsCyan;
                objGraphicsCyan = CreateGraphics();
                objGraphicsCyan.Clear(SystemColors.Control);
                objGraphicsCyan.DrawRectangle(Pens.Cyan, 1, 1, 378, 357);
                objGraphicsCyan.Dispose();
            }
            else if (isDefault)
            {
                Graphics objGraphicsDefault;
                objGraphicsDefault = CreateGraphics();
                objGraphicsDefault.Clear(SystemColors.Control);
                objGraphicsDefault.DrawRectangle(Pens.White, 1, 1, 375, 355);
                objGraphicsDefault.Dispose();
            }

            white = false;
            blue = false;
            green = true;
            orange = false;
        }
        //following events are for changing the background
        //must remain visible, so change selected color to black
        //make sure all other colors stay the preview color
        private void blueBtn_CheckedChanged(object sender, EventArgs e)
        {
          this.BackColor= Color.Blue;
            defaultButton.ForeColor = Color.White;
            orangeBtn.ForeColor = Color.Orange;
            greenBtn.ForeColor = Color.Green;
            blueBtn.ForeColor = Color.Black;

            //following ifs are if border is shown, so keep showing
            if (isYellow)
            {
                Graphics objGraphicsyellow;
                objGraphicsyellow = CreateGraphics();
                objGraphicsyellow.Clear(SystemColors.Control);
                objGraphicsyellow.DrawRectangle(Pens.Yellow, 1, 1, 378, 357);
                objGraphicsyellow.Dispose();
            }
            else if (isPurple)
            {
                Graphics objGraphicsPurple;
                objGraphicsPurple = CreateGraphics();
                objGraphicsPurple.Clear(SystemColors.Control);
                objGraphicsPurple.DrawRectangle(Pens.Purple, 1, 1, 378, 357);
                objGraphicsPurple.Dispose();
            }
            else if (isIndigo)
            {
                Graphics objGraphicsIndigo;
                objGraphicsIndigo = CreateGraphics();
                objGraphicsIndigo.Clear(SystemColors.Control);
                objGraphicsIndigo.DrawRectangle(Pens.Indigo, 1, 1, 378, 357);
                objGraphicsIndigo.Dispose();
            }
            else if(isCyan)
            {
                Graphics objGraphicsCyan;
                objGraphicsCyan = CreateGraphics();
                objGraphicsCyan.Clear(SystemColors.Control);
                objGraphicsCyan.DrawRectangle(Pens.Cyan, 1, 1, 378, 357);
                objGraphicsCyan.Dispose();
            }
            else if(isDefault)
            {
                Graphics objGraphicsDefault;
                objGraphicsDefault = CreateGraphics();
                objGraphicsDefault.Clear(SystemColors.Control);
                objGraphicsDefault.DrawRectangle(Pens.White, 1, 1, 375, 355);
                objGraphicsDefault.Dispose();
            }

            white = false;
            blue = true;
            green = false;
            orange = false;
        }

        //check if selection is changed, then draw the border
        private void CboBorderColors_SelectedIndexChanged(object sender, EventArgs e)
        {
            
            switch (CboBorderColors.Text)
            {
                case "cyan":
                    MessageBox.Show("Cyan was chosen");
                    Graphics objGraphicsCyan;
                    objGraphicsCyan = CreateGraphics();
                    objGraphicsCyan.Clear(SystemColors.Control);
                    objGraphicsCyan.DrawRectangle(Pens.Cyan, 1, 1, 378, 357);
                    objGraphicsCyan.Dispose();
                    //update so that it draws even with background color change
                    isCyan = true;
                    isDefault = false;
                    isIndigo = false;
                    isPurple = false;
                    isYellow = false;
                    break;
                case "yellow":
                    MessageBox.Show("Yellow was chosen");
                    Graphics objGraphicsyellow;
                    objGraphicsyellow = CreateGraphics();
                    objGraphicsyellow.Clear(SystemColors.Control);
                    objGraphicsyellow.DrawRectangle(Pens.Yellow,1,1, 378, 357);
                    objGraphicsyellow.Dispose();
                    //update so that it draws even with background color change
                    isCyan = true;
                    isDefault = false;
                    isIndigo = false;
                    isPurple = false;
                    isYellow = true;
                    break;
                case "purple":
                    MessageBox.Show("Purple was chosen");
                    Graphics objGraphicsPurple;
                    objGraphicsPurple = CreateGraphics();
                    objGraphicsPurple.Clear(SystemColors.Control);
                    objGraphicsPurple.DrawRectangle(Pens.Purple,1,1, 378, 357);
                    objGraphicsPurple.Dispose();
                    //update so that it draws even with background color change
                    isCyan = true;
                    isDefault = false;
                    isIndigo = false;
                    isPurple = true;
                    isYellow = false;
                    break;
                case "indigo":
                    MessageBox.Show("Indigo was chosen");
                    Graphics objGraphicsIndigo;
                    objGraphicsIndigo = CreateGraphics();
                    objGraphicsIndigo.Clear(SystemColors.Control);
                    objGraphicsIndigo.DrawRectangle(Pens.Indigo,1, 1, 378, 357);
                    objGraphicsIndigo.Dispose();
                    //update so that it draws even with background color change
                    isCyan = true;
                    isDefault = false;
                    isIndigo = true;
                    isPurple = false;
                    isYellow = false;
                    break;
                default:
                    MessageBox.Show("Back to the default");
                    Graphics objGraphicsDefault;
                    objGraphicsDefault = CreateGraphics();
                    objGraphicsDefault.Clear(SystemColors.Control);
                    objGraphicsDefault.DrawRectangle(Pens.White, 1, 1, 375, 355);
                    objGraphicsDefault.Dispose();
                    //update so that it draws even with background color change
                    isCyan = true;
                    isDefault = true;
                    isIndigo = false;
                    isPurple = false;
                    isYellow = false;
                    break;
            }
            //redraw the background color
            if (white)
            {
                defaultButton_CheckedChanged(sender, e);
            }
            else if (blue)
            {
                blueBtn_CheckedChanged(sender, e);
            }
            else if (green)
            {
                greenBtn_CheckedChanged(sender, e);
            }
            else if (orange)
            {
                orangeBtn_CheckedChanged(sender, e);
            }
        }
    }
}
