// accessibility.js - Updated version
let currentFontSize = 16;

function toggleContrast() {
  document.body.classList.toggle('high-contrast');
  const isHighContrast = document.body.classList.contains('high-contrast');
  localStorage.setItem('highContrast', isHighContrast);
  
  // For screen reader announcement
  const announcement = document.createElement('div');
  announcement.setAttribute('aria-live', 'polite');
  announcement.className = 'sr-only';
  announcement.textContent = isHighContrast ? 'High contrast mode enabled' : 'High contrast mode disabled';
  document.body.appendChild(announcement);
  setTimeout(() => announcement.remove(), 100);
}

function changeFontSize(amount) {
  currentFontSize = Math.max(10, Math.min(32, currentFontSize + amount));
  document.body.style.fontSize = currentFontSize + 'px';
  localStorage.setItem('fontSize', currentFontSize);
}

function resetFontSize() {
  currentFontSize = 16;
  document.body.style.fontSize = currentFontSize + 'px';
  localStorage.setItem('fontSize', currentFontSize);
}

function loadAccessibilityPreferences() {
  // Only apply high contrast if explicitly set to true
  const highContrast = localStorage.getItem('highContrast');
  if (highContrast === 'true') {
    document.body.classList.add('high-contrast');
  } else if (highContrast === null) {
    // Default to normal mode if no preference exists
    document.body.classList.remove('high-contrast');
    localStorage.setItem('highContrast', 'false');
  }
  
  // Font size loading remains the same
  const savedFontSize = localStorage.getItem('fontSize');
  if (savedFontSize) {
    currentFontSize = parseInt(savedFontSize);
    document.body.style.fontSize = currentFontSize + 'px';
  }
}

// Initialize when DOM is loaded
document.addEventListener('DOMContentLoaded', function() {
  loadAccessibilityPreferences();
  
  // Check for images without alt text (for debugging)
  const images = document.querySelectorAll('img:not([alt])');
  if (images.length > 0) {
    console.warn('Accessibility: Found images without alt text:', images);
  }
});

// Make functions available globally
window.toggleContrast = toggleContrast;
window.changeFontSize = changeFontSize;
window.resetFontSize = resetFontSize;