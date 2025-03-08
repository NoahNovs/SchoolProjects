using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PostFixCalculator
{
    public partial class FrmPostFixCalculator : Form
    {
        public FrmPostFixCalculator()
        {
            InitializeComponent();
        }
        double dblFirstNum = 0;
        double dblSecondNum = 0;
        double dblResult = 0;
        string strFirstNum = "0";
        string strSecondNum = "0";
        string strResult = "0";
        string strTest = "0";
        double dblNumCheck = 0;
        public bool isNum;

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void TxtFirstNum_Leave(object sender, EventArgs e)
        {
            strFirstNum = TxtFirstNum.Text.ToString();
            strTest = strFirstNum;
            isNum = double.TryParse(strTest,out dblNumCheck);

            if(strFirstNum.Equals(""))
            {
                strFirstNum = "0";
                TxtFirstNum.Text = strFirstNum;
                MessageBox.Show("OOPS!!! You didn't enter anything." +
                    " Please try again");
                TxtFirstNum.Focus();
            }
            else
            {
                if (isNum)
                {
                    dblFirstNum = double.Parse(strFirstNum);
                }
                else
                {
                    TxtFirstNum.Text = "";
                    strFirstNum = "";
                    TxtFirstNum.Lines.Initialize();
                    MessageBox.Show("That is not a number." +
                        " PRESS CLEAR and try again.");
                }
            }

            
        }

        private void BtnClear_Click(object sender, EventArgs e)
        {
            TxtFirstNum.Text = "0";
            TxtSecondNum.Text = "0";
            TxtResult.Text = "";
        }

        private void TxtSecondNum_Leave(object sender, EventArgs e)
        {
            strSecondNum = TxtSecondNum.Text.ToString();
            strTest = strSecondNum;
            isNum = double.TryParse(strTest, out dblNumCheck);

            if (strSecondNum.Equals(""))
            {
                strSecondNum = "0";
                TxtSecondNum.Text = strSecondNum;
                MessageBox.Show("OOPS!!! You didn't enter anything." +
                    " Please try again");
                TxtFirstNum.Focus();
            }
            else
            {
                if (isNum)
                {
                    dblSecondNum = double.Parse(strSecondNum);
                }
                else
                {
                    TxtSecondNum.Text = "";
                    strSecondNum = "";
                    TxtSecondNum.Lines.Initialize();
                    MessageBox.Show("That is not a number." +
                        " PRESS CLEAR and try again.");
                }
            }

            
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            dblResult = (dblFirstNum + dblSecondNum);
            strResult = dblResult.ToString();
            TxtResult.Text = strResult;
        }

        private void BtnSubt_Click(object sender, EventArgs e)
        {
            dblResult = (dblFirstNum - dblSecondNum);
            strResult = dblResult.ToString();
            TxtResult.Text = strResult;
        }

        private void BtnMult_Click(object sender, EventArgs e)
        {
            dblResult = (dblFirstNum * dblSecondNum);
            strResult = dblResult.ToString();
            TxtResult.Text = strResult;
        }

        private void MultDiv_Click(object sender, EventArgs e)
        {
            dblResult = (dblFirstNum / dblSecondNum);
            strResult = dblResult.ToString();
            TxtResult.Text = strResult;
        }

        private void FrmPostFixCalculator_Load(object sender, EventArgs e)
        {
            TxtFirstNum.Text = "First Number";
            TxtSecondNum.Text = "Second Number";
        }

        private void TxtFirstNum_MouseDown(object sender, MouseEventArgs e)
        {
            TxtFirstNum.Text = "";
        }

        private void TxtSecondNum_MouseDown(object sender, MouseEventArgs e)
        {
            TxtSecondNum.Text = "";
        }

        private void BtnQuit_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
