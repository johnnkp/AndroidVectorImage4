// https://android.googlesource.com/platform/frameworks/support/+/refs/tags/android-8.1.0_r64/graphics/drawable/static/src/android/support/graphics/drawable/VectorDrawableCommon.java
package hkcc.ccn3165.vectorimage4;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;

/**
 * Internal common delegation shared by VectorDrawableCompat and AnimatedVectorDrawableCompat
 */
abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {

    // Drawable delegation for supported API levels.
    Drawable mDelegateDrawable;

    @Override
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setColorFilter(color, mode);
            return;
        }
        super.setColorFilter(color, mode);
    }

    @Override
    public ColorFilter getColorFilter() {
        if (mDelegateDrawable != null) {
            return DrawableCompat.getColorFilter(mDelegateDrawable);
        }
        return null;
    }

    @Override
    protected boolean onLevelChange(int level) {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.setLevel(level);
        }
        return super.onLevelChange(level);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setBounds(bounds);
            return;
        }
        super.onBoundsChange(bounds);
    }

    @Override
    public void setHotspot(float x, float y) {
        if (mDelegateDrawable != null) {
            DrawableCompat.setHotspot(mDelegateDrawable, x, y);
        }
        return;
    }

    @Override
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        if (mDelegateDrawable != null) {
            DrawableCompat.setHotspotBounds(mDelegateDrawable, left, top, right, bottom);
            return;
        }
    }

    @Override
    public void setFilterBitmap(boolean filter) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setFilterBitmap(filter);
            return;
        }
    }

    @Override
    public void jumpToCurrentState() {
        if (mDelegateDrawable != null) {
            DrawableCompat.jumpToCurrentState(mDelegateDrawable);
            return;
        }
    }

    @Override
    public void applyTheme(Resources.Theme t) {
        // API >= 21 only.
        if (mDelegateDrawable != null) {
            DrawableCompat.applyTheme(mDelegateDrawable, t);
            return;
        }
    }

    @Override
    public void clearColorFilter() {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    @Override
    public Drawable getCurrent() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getCurrent();
        }
        return super.getCurrent();
    }

    @Override
    public int getMinimumWidth() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override
    public int getMinimumHeight() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override
    public boolean getPadding(Rect padding) {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getPadding(padding);
        }
        return super.getPadding(padding);
    }

    @Override
    public int[] getState() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getState();
        }
        return super.getState();
    }


    @Override
    public Region getTransparentRegion() {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override
    public void setChangingConfigurations(int configs) {
        if (mDelegateDrawable != null) {
            mDelegateDrawable.setChangingConfigurations(configs);
            return;
        }
        super.setChangingConfigurations(configs);
    }

    @Override
    public boolean setState(int[] stateSet) {
        if (mDelegateDrawable != null) {
            return mDelegateDrawable.setState(stateSet);
        }
        return super.setState(stateSet);
    }
}
