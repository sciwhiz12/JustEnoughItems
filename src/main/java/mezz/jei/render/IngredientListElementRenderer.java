package mezz.jei.render;

import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.ITypedIngredient;
import net.minecraft.client.renderer.Rect2i;

import java.util.Optional;

public class IngredientListElementRenderer<T> {
	private static final Rect2i DEFAULT_AREA = new Rect2i(0, 0, 16, 16);

	private final ITypedIngredient<T> ingredient;
	private Rect2i area = DEFAULT_AREA;
	private int padding;

	public IngredientListElementRenderer(ITypedIngredient<T> ingredient) {
		this.ingredient = ingredient;
	}

	public void setArea(Rect2i area) {
		this.area = area;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public ITypedIngredient<T> getTypedIngredient() {
		return ingredient;
	}

	public Rect2i getArea() {
		return area;
	}

	public int getPadding() {
		return padding;
	}

	public <V> Optional<IngredientListElementRenderer<V>> checkedCast(IIngredientType<V> ingredientType) {
		if (ingredient.getType() == ingredientType) {
			@SuppressWarnings("unchecked")
			IngredientListElementRenderer<V> castElement = (IngredientListElementRenderer<V>) this;
			return Optional.of(castElement);
		}
		return Optional.empty();
	}
}
