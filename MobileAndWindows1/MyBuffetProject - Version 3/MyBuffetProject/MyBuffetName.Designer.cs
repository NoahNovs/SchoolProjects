namespace MyBuffetProject
{
    partial class MyBuffetName
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.PicBox = new System.Windows.Forms.PictureBox();
            this.SelectPictureButton = new System.Windows.Forms.Button();
            this.quitButton = new System.Windows.Forms.Button();
            this.ofdSelectPic = new System.Windows.Forms.OpenFileDialog();
            this.growButton = new System.Windows.Forms.Button();
            this.shrinkButton = new System.Windows.Forms.Button();
            this.DrawBoarderButton = new System.Windows.Forms.Button();
            this.labelX = new System.Windows.Forms.Label();
            this.labelY = new System.Windows.Forms.Label();
            this.BtnOptions = new System.Windows.Forms.Button();
            this.ChkPromptExit = new System.Windows.Forms.CheckBox();
            ((System.ComponentModel.ISupportInitialize)(this.PicBox)).BeginInit();
            this.SuspendLayout();
            // 
            // PicBox
            // 
            this.PicBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.PicBox.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.PicBox.Location = new System.Drawing.Point(10, 10);
            this.PicBox.Name = "PicBox";
            this.PicBox.Size = new System.Drawing.Size(650, 590);
            this.PicBox.TabIndex = 0;
            this.PicBox.TabStop = false;
            this.PicBox.MouseLeave += new System.EventHandler(this.PicBox_MouseLeave);
            this.PicBox.MouseMove += new System.Windows.Forms.MouseEventHandler(this.PicBox_MouseMove);
            // 
            // SelectPictureButton
            // 
            this.SelectPictureButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.SelectPictureButton.Location = new System.Drawing.Point(675, 10);
            this.SelectPictureButton.Name = "SelectPictureButton";
            this.SelectPictureButton.Size = new System.Drawing.Size(85, 23);
            this.SelectPictureButton.TabIndex = 1;
            this.SelectPictureButton.Text = "Select Picture";
            this.SelectPictureButton.UseVisualStyleBackColor = true;
            this.SelectPictureButton.Click += new System.EventHandler(this.SelectPictureButton_Click);
            // 
            // quitButton
            // 
            this.quitButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.quitButton.Location = new System.Drawing.Point(675, 39);
            this.quitButton.Name = "quitButton";
            this.quitButton.Size = new System.Drawing.Size(85, 23);
            this.quitButton.TabIndex = 2;
            this.quitButton.Text = "Quit";
            this.quitButton.UseVisualStyleBackColor = true;
            this.quitButton.Click += new System.EventHandler(this.quitButton_Click);
            // 
            // ofdSelectPic
            // 
            this.ofdSelectPic.Filter = "Windows Bitmaps|*.BMP|JPEG|*.JPG";
            this.ofdSelectPic.Title = "Select Picture";
            // 
            // growButton
            // 
            this.growButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.growButton.Location = new System.Drawing.Point(750, 540);
            this.growButton.Name = "growButton";
            this.growButton.Size = new System.Drawing.Size(23, 23);
            this.growButton.TabIndex = 3;
            this.growButton.Text = "v";
            this.growButton.UseVisualStyleBackColor = true;
            this.growButton.Click += new System.EventHandler(this.growButton_Click);
            // 
            // shrinkButton
            // 
            this.shrinkButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.shrinkButton.Location = new System.Drawing.Point(750, 570);
            this.shrinkButton.Name = "shrinkButton";
            this.shrinkButton.Size = new System.Drawing.Size(23, 23);
            this.shrinkButton.TabIndex = 4;
            this.shrinkButton.Text = "^";
            this.shrinkButton.UseVisualStyleBackColor = true;
            this.shrinkButton.Click += new System.EventHandler(this.shrinkButton_Click);
            // 
            // DrawBoarderButton
            // 
            this.DrawBoarderButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.DrawBoarderButton.Location = new System.Drawing.Point(675, 70);
            this.DrawBoarderButton.Name = "DrawBoarderButton";
            this.DrawBoarderButton.Size = new System.Drawing.Size(85, 23);
            this.DrawBoarderButton.TabIndex = 5;
            this.DrawBoarderButton.Text = "Draw Boarder";
            this.DrawBoarderButton.UseVisualStyleBackColor = true;
            this.DrawBoarderButton.Click += new System.EventHandler(this.DrawBoarderButton_Click);
            // 
            // labelX
            // 
            this.labelX.AutoSize = true;
            this.labelX.Location = new System.Drawing.Point(670, 240);
            this.labelX.Name = "labelX";
            this.labelX.Size = new System.Drawing.Size(14, 13);
            this.labelX.TabIndex = 6;
            this.labelX.Text = "X";
            this.labelX.Click += new System.EventHandler(this.labelX_Click);
            // 
            // labelY
            // 
            this.labelY.AutoSize = true;
            this.labelY.Location = new System.Drawing.Point(670, 270);
            this.labelY.Name = "labelY";
            this.labelY.Size = new System.Drawing.Size(14, 13);
            this.labelY.TabIndex = 7;
            this.labelY.Text = "Y";
            // 
            // BtnOptions
            // 
            this.BtnOptions.Location = new System.Drawing.Point(670, 100);
            this.BtnOptions.Name = "BtnOptions";
            this.BtnOptions.Size = new System.Drawing.Size(95, 23);
            this.BtnOptions.TabIndex = 8;
            this.BtnOptions.Text = "Options";
            this.BtnOptions.UseVisualStyleBackColor = true;
            this.BtnOptions.Click += new System.EventHandler(this.BtnOptions_Click);
            // 
            // ChkPromptExit
            // 
            this.ChkPromptExit.AutoSize = true;
            this.ChkPromptExit.Location = new System.Drawing.Point(673, 130);
            this.ChkPromptExit.Name = "ChkPromptExit";
            this.ChkPromptExit.Size = new System.Drawing.Size(99, 17);
            this.ChkPromptExit.TabIndex = 9;
            this.ChkPromptExit.Text = "Confirm to Exit?";
            this.ChkPromptExit.UseVisualStyleBackColor = true;
            this.ChkPromptExit.CheckedChanged += new System.EventHandler(this.ChkPromptExit_CheckedChanged);
            // 
            // MyBuffetName
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(784, 611);
            this.Controls.Add(this.ChkPromptExit);
            this.Controls.Add(this.BtnOptions);
            this.Controls.Add(this.labelY);
            this.Controls.Add(this.labelX);
            this.Controls.Add(this.DrawBoarderButton);
            this.Controls.Add(this.shrinkButton);
            this.Controls.Add(this.growButton);
            this.Controls.Add(this.quitButton);
            this.Controls.Add(this.SelectPictureButton);
            this.Controls.Add(this.PicBox);
            this.MinimumSize = new System.Drawing.Size(740, 590);
            this.Name = "MyBuffetName";
            this.Text = "A290 Buffet";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MyBuffetName_FormClosing);
            this.Load += new System.EventHandler(this.MyBuffetName_Load);
            ((System.ComponentModel.ISupportInitialize)(this.PicBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox PicBox;
        private System.Windows.Forms.Button SelectPictureButton;
        private System.Windows.Forms.Button quitButton;
        private System.Windows.Forms.OpenFileDialog ofdSelectPic;
        private System.Windows.Forms.Button growButton;
        private System.Windows.Forms.Button shrinkButton;
        private System.Windows.Forms.Button DrawBoarderButton;
        private System.Windows.Forms.Label labelX;
        private System.Windows.Forms.Label labelY;
        private System.Windows.Forms.Button BtnOptions;
        private System.Windows.Forms.CheckBox ChkPromptExit;
    }
}

