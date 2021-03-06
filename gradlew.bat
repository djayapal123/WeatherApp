<?xml version="1.0" encoding="utf-8"?>

<RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"

        >
        <ImageView
            android:id="@+id/iv_category"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:scaleType="fitXY"
            android:src="@drawable/product_academy"
            />
        <TextView
            android:id="@+id/tv_categoryName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:fontFamily="@font/graphik_regular"
            android:layout_gravity="center"
            android:gravity="center_horizontal"
            android:layout_marginTop="10dp"
            android:text="@string/product_academy"
            android:textColor="@color/textColor"
            android:textSize="16sp" />
        <TextView
            android:id="@+id/tv_comingSoon"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:fontFamily="@font/graphik_regular"
            android:gravity="center_horizontal"
            android:layout_below="@+id/tv_categoryName"
            android:textSize="16sp"
        />
        <ProgressBar
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:indeterminateDrawable="@drawable/progress_dialog_anim_shape"
            android:id="@+id/image_progress_bar"
            />
</RelativeLayout>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              