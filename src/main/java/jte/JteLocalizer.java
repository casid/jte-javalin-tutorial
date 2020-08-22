package jte;

import app.util.Localizer;
import gg.jte.support.LocalizationSupport;

public class JteLocalizer implements LocalizationSupport {
    private final Localizer localizer;

    public JteLocalizer(Localizer localizer) {
        this.localizer = localizer;
    }

    @Override
    public String lookup(String key) {
        return localizer.localize(key);
    }
}
