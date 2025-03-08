using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyBuffetProject
{
    public partial class FrmBuffetOptions : Form
    {
        public FrmBuffetOptions()
        {
            InitializeComponent();
        }

        private void BtnOK_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void BtnCancel_Click(object sender, EventArgs e)
        {
            Close();
        }
        //ignore, accidentally clicked it
        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void redBtn_CheckedChanged(object sender, EventArgs e)
        {
            BackColor = Color.Red;
        }

        private void orangeBtn_CheckedChanged(object sender, EventArgs e)
        {
            BackColor = Color.Orange;
        }

        private void greenBtn_CheckedChanged(object sender, EventArgs e)
        {
            BackColor = Color.Green;
        }

        private void blueBtn_CheckedChanged(object sender, EventArgs e)
        {
            BackColor = Color.Blue;
        }

        private void CboBorderColors_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch(CboBorderColors.Text)
            {
                case "cyan":
                    MessageBox.Show("Cyan was chosen");
                    Graphics objGraphicsCyan = null;
                    objGraphicsCyan = CreateGraphics();
                    objGraphicsCyan.Clear(SystemColors.Control);
                    objGraphicsCyan.DrawRectangle(Pens.Cyan, 1, 1, 481, 458);
                    objGraphicsCyan.Dispose();
                    break;
                default:
                    MessageBox.Show("Back to the default");
                    Graphics objGraphicsDefault;
                    objGraphicsDefault = CreateGraphics();
                    objGraphicsDefault.Clear(SystemColors.Control);
                    objGraphicsDefault.DrawRectangle(Pens.BlanchedAlmond, 1, 1, 481, 458);
                    objGraphicsDefault.Dispose();
                    break;
            }
        }
    }
}
