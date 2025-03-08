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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MyBuffetName));
            this.SelectPictureButton = new System.Windows.Forms.Button();
            this.quitButton = new System.Windows.Forms.Button();
            this.ofdSelectPic = new System.Windows.Forms.OpenFileDialog();
            this.DrawBoarderButton = new System.Windows.Forms.Button();
            this.labelX = new System.Windows.Forms.Label();
            this.labelY = new System.Windows.Forms.Label();
            this.optionsButton = new System.Windows.Forms.Button();
            this.collectionButton = new System.Windows.Forms.Button();
            this.exitBox = new System.Windows.Forms.CheckBox();
            this.shrinkButton = new System.Windows.Forms.Button();
            this.growButton = new System.Windows.Forms.Button();
            this.PicBox = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.PicBox)).BeginInit();
            this.SuspendLayout();
            // 
            // SelectPictureButton
            // 
            this.SelectPictureButton.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.SelectPictureButton.Location = new System.Drawing.Point(12, 12);
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
            this.quitButton.Cursor = System.Windows.Forms.Cursors.Hand;
            this.quitButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.quitButton.ForeColor = System.Drawing.Color.Red;
            this.quitButton.Location = new System.Drawing.Point(681, 12);
            this.quitButton.Name = "quitButton";
            this.quitButton.Size = new System.Drawing.Size(85, 23);
            this.quitButton.TabIndex = 2;
            this.quitButton.Text = "Quit";
            this.quitButton.UseVisualStyleBackColor = true;
            this.quitButton.Click += new System.EventHandler(this.quitButton_Click);
            // 
            // ofdSelectPic
            // 
            this.ofdSelectPic.Filter = "Windows Bitmaps|*.BMP|JPEG|*.JPG|PNG|*.PNG|GIF|.GIF";
            this.ofdSelectPic.Title = "Select Picture";
            // 
            // DrawBoarderButton
            // 
            this.DrawBoarderButton.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.DrawBoarderButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.DrawBoarderButton.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.DrawBoarderButton.Location = new System.Drawing.Point(103, 12);
            this.DrawBoarderButton.Name = "DrawBoarderButton";
            this.DrawBoarderButton.Size = new System.Drawing.Size(94, 23);
            this.DrawBoarderButton.TabIndex = 5;
            this.DrawBoarderButton.Text = "Draw Boarder";
            this.DrawBoarderButton.UseVisualStyleBackColor = true;
            this.DrawBoarderButton.Click += new System.EventHandler(this.DrawBoarderButton_Click);
            // 
            // labelX
            // 
            this.labelX.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.labelX.AutoSize = true;
            this.labelX.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelX.Location = new System.Drawing.Point(53, 589);
            this.labelX.Name = "labelX";
            this.labelX.Size = new System.Drawing.Size(17, 17);
            this.labelX.TabIndex = 6;
            this.labelX.Text = "X";
            this.labelX.Click += new System.EventHandler(this.labelX_Click);
            // 
            // labelY
            // 
            this.labelY.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.labelY.AutoSize = true;
            this.labelY.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelY.Location = new System.Drawing.Point(120, 589);
            this.labelY.Name = "labelY";
            this.labelY.Size = new System.Drawing.Size(17, 17);
            this.labelY.TabIndex = 7;
            this.labelY.Text = "Y";
            // 
            // optionsButton
            // 
            this.optionsButton.Location = new System.Drawing.Point(600, 12);
            this.optionsButton.Name = "optionsButton";
            this.optionsButton.Size = new System.Drawing.Size(75, 23);
            this.optionsButton.TabIndex = 8;
            this.optionsButton.Text = "Options";
            this.optionsButton.UseVisualStyleBackColor = true;
            this.optionsButton.Click += new System.EventHandler(this.optionsButton_Click);
            // 
            // collectionButton
            // 
            this.collectionButton.Location = new System.Drawing.Point(203, 12);
            this.collectionButton.Name = "collectionButton";
            this.collectionButton.Size = new System.Drawing.Size(75, 23);
            this.collectionButton.TabIndex = 9;
            this.collectionButton.Text = "Collection";
            this.collectionButton.UseVisualStyleBackColor = true;
            this.collectionButton.Click += new System.EventHandler(this.collectionButton_Click);
            // 
            // exitBox
            // 
            this.exitBox.AutoSize = true;
            this.exitBox.Location = new System.Drawing.Point(495, 16);
            this.exitBox.Name = "exitBox";
            this.exitBox.Size = new System.Drawing.Size(99, 17);
            this.exitBox.TabIndex = 10;
            this.exitBox.Text = "Confirm to Exit?";
            this.exitBox.UseVisualStyleBackColor = true;
            this.exitBox.CheckedChanged += new System.EventHandler(this.exitBox_CheckedChanged);
            // 
            // shrinkButton
            // 
            this.shrinkButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.shrinkButton.BackColor = System.Drawing.SystemColors.Info;
            this.shrinkButton.BackgroundImage = global::MyBuffetProject.Properties.Resources.arrow_shrink_icon_icons_com_50462;
            this.shrinkButton.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.shrinkButton.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.shrinkButton.Location = new System.Drawing.Point(12, 589);
            this.shrinkButton.Name = "shrinkButton";
            this.shrinkButton.Size = new System.Drawing.Size(35, 31);
            this.shrinkButton.TabIndex = 4;
            this.shrinkButton.UseVisualStyleBackColor = false;
            this.shrinkButton.Click += new System.EventHandler(this.shrinkButton_Click);
            // 
            // growButton
            // 
            this.growButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.growButton.BackColor = System.Drawing.SystemColors.Info;
            this.growButton.BackgroundImage = global::MyBuffetProject.Properties.Resources.increase_size_option_icon_icons_com_73526;
            this.growButton.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.growButton.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.growButton.Location = new System.Drawing.Point(734, 589);
            this.growButton.Name = "growButton";
            this.growButton.Size = new System.Drawing.Size(32, 31);
            this.growButton.TabIndex = 3;
            this.growButton.UseVisualStyleBackColor = false;
            this.growButton.Click += new System.EventHandler(this.growButton_Click);
            // 
            // PicBox
            // 
            this.PicBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.PicBox.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.PicBox.Location = new System.Drawing.Point(12, 41);
            this.PicBox.Name = "PicBox";
            this.PicBox.Size = new System.Drawing.Size(754, 542);
            this.PicBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.PicBox.TabIndex = 0;
            this.PicBox.TabStop = false;
            this.PicBox.MouseLeave += new System.EventHandler(this.PicBox_MouseLeave);
            this.PicBox.MouseMove += new System.Windows.Forms.MouseEventHandler(this.PicBox_MouseMove);
            // 
            // MyBuffetName
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(778, 624);
            this.Controls.Add(this.exitBox);
            this.Controls.Add(this.collectionButton);
            this.Controls.Add(this.optionsButton);
            this.Controls.Add(this.labelY);
            this.Controls.Add(this.labelX);
            this.Controls.Add(this.DrawBoarderButton);
            this.Controls.Add(this.shrinkButton);
            this.Controls.Add(this.growButton);
            this.Controls.Add(this.quitButton);
            this.Controls.Add(this.SelectPictureButton);
            this.Controls.Add(this.PicBox);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(740, 590);
            this.Name = "MyBuffetName";
            this.Text = "A290 Buffet";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MyBuffetName_FormClosing);
            this.Load += new System.EventHandler(this.MyBuffetName_Load);
            this.LocationChanged += new System.EventHandler(this.MyBuffetName_LocationChanged);
            this.RegionChanged += new System.EventHandler(this.MyBuffetName_RegionChanged);
            this.Leave += new System.EventHandler(this.MyBuffetName_Leave);
            this.Resize += new System.EventHandler(this.MyBuffetName_Resize);
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
        private System.Windows.Forms.Button optionsButton;
        private System.Windows.Forms.Button collectionButton;
        private System.Windows.Forms.CheckBox exitBox;
    }
}

