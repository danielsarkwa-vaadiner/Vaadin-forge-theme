import 'construct-style-sheets-polyfill';
import { unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin/register-styles';

const createLinkReferences = (css, target) => {
  // Unresolved urls are written as '@import url(text);' to the css
  // [0] is the full match
  // [1] matches the media query
  // [2] matches the url
  const importMatcher = /(?:@media\s(.+?))?(?:\s{)?\@import\surl\((.+?)\);(?:})?/g;
  
  var match;
  var styleCss = css;
  
  // For each external url import add a link reference
  while((match = importMatcher.exec(css)) !== null) {
    styleCss = styleCss.replace(match[0], "");
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = match[2];
    if (match[1]) {
      link.media = match[1];
    }
    // For target document append to head else append to target
    if (target === document) {
      document.head.appendChild(link);
    } else {
      target.appendChild(link);
    }
  };
  return styleCss;
};

// target: Document | ShadowRoot
export const injectGlobalCss = (css, target, first) => {
  if(target === document) {
    const hash = getHash(css);
    if (window.Vaadin.theme.injectedGlobalCss.indexOf(hash) !== -1) {
      return;
    }
    window.Vaadin.theme.injectedGlobalCss.push(hash);
  }
  const sheet = new CSSStyleSheet();
  sheet.replaceSync(createLinkReferences(css,target));
  if (first) {
    target.adoptedStyleSheets = [sheet, ...target.adoptedStyleSheets];
  } else {
    target.adoptedStyleSheets = [...target.adoptedStyleSheets, sheet];
  }
};
import stylesCss from 'themes/forge-tech/styles.css?inline';
import { typography } from '@vaadin/vaadin-lumo-styles/typography.js';
import { color } from '@vaadin/vaadin-lumo-styles/color.js';
import { spacing } from '@vaadin/vaadin-lumo-styles/spacing.js';
import { badge } from '@vaadin/vaadin-lumo-styles/badge.js';
import { utility } from '@vaadin/vaadin-lumo-styles/utility.js';
import commonFieldLabelCss from 'themes/forge-tech/components/common-field-label.css?inline';
import commonInputFieldCss from 'themes/forge-tech/components/common-input-field.css?inline';
import textCss from 'themes/forge-tech/components/text.css?inline';
import vaadinAccordionPanelCss from 'themes/forge-tech/components/vaadin-accordion-panel.css?inline';
import vaadinButtonCss from 'themes/forge-tech/components/vaadin-button.css?inline';
import vaadinCheckboxCss from 'themes/forge-tech/components/vaadin-checkbox.css?inline';
import vaadinComboBoxOverlayCss from 'themes/forge-tech/components/vaadin-combo-box-overlay.css?inline';
import vaadinComboBoxCss from 'themes/forge-tech/components/vaadin-combo-box.css?inline';
import vaadinDatePickerCss from 'themes/forge-tech/components/vaadin-date-picker.css?inline';
import vaadinDateTimePickerCss from 'themes/forge-tech/components/vaadin-date-time-picker.css?inline';
import vaadinDetailsCss from 'themes/forge-tech/components/vaadin-details.css?inline';
import vaadinDialogOverlayCss from 'themes/forge-tech/components/vaadin-dialog-overlay.css?inline';
import vaadinEmailFieldCss from 'themes/forge-tech/components/vaadin-email-field.css?inline';
import vaadinInputContainerCss from 'themes/forge-tech/components/vaadin-input-container.css?inline';
import vaadinNumberFieldCss from 'themes/forge-tech/components/vaadin-number-field.css?inline';
import vaadinPasswordFieldCss from 'themes/forge-tech/components/vaadin-password-field.css?inline';
import vaadinRadioButtonCss from 'themes/forge-tech/components/vaadin-radio-button.css?inline';
import vaadinSelectValueButtonCss from 'themes/forge-tech/components/vaadin-select-value-button.css?inline';
import vaadinSelectCss from 'themes/forge-tech/components/vaadin-select.css?inline';
import vaadinTabCss from 'themes/forge-tech/components/vaadin-tab.css?inline';
import vaadinTabsCss from 'themes/forge-tech/components/vaadin-tabs.css?inline';
import vaadinTextAreaCss from 'themes/forge-tech/components/vaadin-text-area.css?inline';
import vaadinTextFieldCss from 'themes/forge-tech/components/vaadin-text-field.css?inline';
import vaadinTimePickerCss from 'themes/forge-tech/components/vaadin-time-picker.css?inline';

window.Vaadin = window.Vaadin || {};
window.Vaadin.theme = window.Vaadin.theme || {};
window.Vaadin.theme.injectedGlobalCss = [];

/**
 * Calculate a 32 bit FNV-1a hash
 * Found here: https://gist.github.com/vaiorabbit/5657561
 * Ref.: http://isthe.com/chongo/tech/comp/fnv/
 *
 * @param {string} str the input value
 * @returns {string} 32 bit (as 8 byte hex string)
 */
function hashFnv32a(str) {
  /*jshint bitwise:false */
  let i, l, hval = 0x811c9dc5;

  for (i = 0, l = str.length; i < l; i++) {
    hval ^= str.charCodeAt(i);
    hval += (hval << 1) + (hval << 4) + (hval << 7) + (hval << 8) + (hval << 24);
  }

  // Convert to 8 digit hex string
  return ("0000000" + (hval >>> 0).toString(16)).substr(-8);
}

/**
 * Calculate a 64 bit hash for the given input.
 * Double hash is used to significantly lower the collision probability.
 *
 * @param {string} input value to get hash for
 * @returns {string} 64 bit (as 16 byte hex string)
 */
function getHash(input) {
  let h1 = hashFnv32a(input); // returns 32 bit (as 8 byte hex string)
  return h1 + hashFnv32a(h1 + input); 
}
export const applyTheme = (target) => {
  
  injectGlobalCss(stylesCss.toString(), target);
    
  
  if (!document['_vaadintheme_forge-tech_componentCss']) {
    registerStyles(
      'common-field-label',
      unsafeCSS(commonFieldLabelCss.toString())
    );
    registerStyles(
      'common-input-field',
      unsafeCSS(commonInputFieldCss.toString())
    );
    registerStyles(
      'text',
      unsafeCSS(textCss.toString())
    );
    registerStyles(
      'vaadin-accordion-panel',
      unsafeCSS(vaadinAccordionPanelCss.toString())
    );
    registerStyles(
      'vaadin-button',
      unsafeCSS(vaadinButtonCss.toString())
    );
    registerStyles(
      'vaadin-checkbox',
      unsafeCSS(vaadinCheckboxCss.toString())
    );
    registerStyles(
      'vaadin-combo-box-overlay',
      unsafeCSS(vaadinComboBoxOverlayCss.toString())
    );
    registerStyles(
      'vaadin-combo-box',
      unsafeCSS(vaadinComboBoxCss.toString())
    );
    registerStyles(
      'vaadin-date-picker',
      unsafeCSS(vaadinDatePickerCss.toString())
    );
    registerStyles(
      'vaadin-date-time-picker',
      unsafeCSS(vaadinDateTimePickerCss.toString())
    );
    registerStyles(
      'vaadin-details',
      unsafeCSS(vaadinDetailsCss.toString())
    );
    registerStyles(
      'vaadin-dialog-overlay',
      unsafeCSS(vaadinDialogOverlayCss.toString())
    );
    registerStyles(
      'vaadin-email-field',
      unsafeCSS(vaadinEmailFieldCss.toString())
    );
    registerStyles(
      'vaadin-input-container',
      unsafeCSS(vaadinInputContainerCss.toString())
    );
    registerStyles(
      'vaadin-number-field',
      unsafeCSS(vaadinNumberFieldCss.toString())
    );
    registerStyles(
      'vaadin-password-field',
      unsafeCSS(vaadinPasswordFieldCss.toString())
    );
    registerStyles(
      'vaadin-radio-button',
      unsafeCSS(vaadinRadioButtonCss.toString())
    );
    registerStyles(
      'vaadin-select-value-button',
      unsafeCSS(vaadinSelectValueButtonCss.toString())
    );
    registerStyles(
      'vaadin-select',
      unsafeCSS(vaadinSelectCss.toString())
    );
    registerStyles(
      'vaadin-tab',
      unsafeCSS(vaadinTabCss.toString())
    );
    registerStyles(
      'vaadin-tabs',
      unsafeCSS(vaadinTabsCss.toString())
    );
    registerStyles(
      'vaadin-text-area',
      unsafeCSS(vaadinTextAreaCss.toString())
    );
    registerStyles(
      'vaadin-text-field',
      unsafeCSS(vaadinTextFieldCss.toString())
    );
    registerStyles(
      'vaadin-time-picker',
      unsafeCSS(vaadinTimePickerCss.toString())
    );
    
    document['_vaadintheme_forge-tech_componentCss'] = true;
  }
  injectGlobalCss(typography.cssText, target, true);
injectGlobalCss(color.cssText, target, true);
injectGlobalCss(spacing.cssText, target, true);
injectGlobalCss(badge.cssText, target, true);
injectGlobalCss(utility.cssText, target, true);

}
