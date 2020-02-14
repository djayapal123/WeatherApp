<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    >
    <LinearLayout
        android:id="@+id/ll_bannerImage1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical"
        >

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <ImageView
                android:id="@+id/imageView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/beautiful_asian_woman_smile"
                android:scaleType="fitXY"
                />

            <TextView
                android:id="@+id/iv_image1Text"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:fontFamily="@font/graphik_regular"
                android:text="@string/sample_text_pro_dynamic_content"
                android:layout_marginLeft="@dimen/home_text_marginLeft"
                android:layout_marginRight="@dimen/layout_margin"
                android:layout_marginTop="@dimen/home_text_margin_top"
                android:gravity="center"
                android:textColor="@color/textColor"
                android:textSize="@dimen/home_text_size"/>

            <TextView
                android:id="@+id/tv_enter"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_below="@id/iv_image1Text"
                android:layout_marginLeft="@dimen/home_small_text_marginLeft"
                android:layout_marginRight="@dimen/layout_margin"
                android:textAlignment="center"
                android:textColor="@color/color_filter"
                android:textSize="@dimen/home_smaller_text_size"
                android:text="Enter >"
                />

        </RelativeLayout>

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="vertical">
        <LinearLayout
            android:id="@+id/ll_barcodeDetail"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:orientation="vertical"

            >

            <ImageView
                android:id="@+id/iv_barcode"
                android:layout_weight="1"
                style="@style/image_view_myacuvue"
                android:layout_gravity="center_horizontal|center_vertical"
                android:layout_marginTop="@dimen/layout_margin"
                android:contentDescription="@string/barcode"/>

            <com.jnj.myacuvue.pro.views.CustomFontTextView
                android:id="@+id/tv_barcodeNumber"
                android:layout_weight="1"
                style="@style/text_home_bar_code_number"/>

        </LinearLayout>
        <LinearLayout
            android:id="@+id/ll_noRoleTagged"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:layout_marginBottom="10dp"
            android:layout_marginTop="@dimen/layout_margin"
            android:orientation="vertical"

            >
            <com.jnj.myacuvue.pro.views.CustomFontButton
                android:id="@+id/btn_hqStoreOwner"
                android:layout_weight="1"
                style="@style/button_blue_big"
                android:text="@string/hq_store_owner"/>

            <com.jnj.myacuvue.pro.views.CustomFontButton
                android:id="@+id/btn_ecpFrontline"
                android:layout_weight="1"
                style="@style/button_blue_big"
                android:layout_below="@id/btn_hqStoreOwner"
                android:text="@string/ecp_frontline_worker"/>


        </LinearLayout>
        <LinearLayout
            android:id="@+id/ll_myStore"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:orientation="vertical"
            android:visibility="gone"
            >

            <com.jnj.myacuvue.pro.views.CustomFontTextView
                android:id="@+id/tv_myStoreText"
                android:layout_weight="1"
                style="@style/text_home_my_store_header"
                android:text="@string/home_myStore"
                />

            <com.jnj.myacuvue.pro.views.CustomFontTextView
                android:id="@+id/tv_myStore"
                android:layout_weight="1"
                style="@style/text_home_my_store_name"
                android:text="@string/home_myStore_register"/>
        </LinearLayout>
        <LinearLayout
            android:id="@+id/ll_bannerImag