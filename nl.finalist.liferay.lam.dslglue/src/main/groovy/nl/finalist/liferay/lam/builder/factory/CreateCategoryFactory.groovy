package nl.finalist.liferay.lam.builder.factory

import nl.finalist.liferay.lam.api.Category;
import nl.finalist.liferay.lam.dslglue.model.CategoryModel;
class CreateCategoryFactory extends AbstractFactory {
	Category categoryService;
	
	CreateCategoryFactory(Category categoryService) {
		this.categoryService = categoryService;
	}
	
	 @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes)
                    throws InstantiationException, IllegalAccessException {
        new CategoryModel(attributes);
    }
    
     @Override
    void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
        super.onNodeCompleted(builder, parent, node);
        CategoryModel category = (CategoryModel) node;
        categoryService.addCategory(category.name, category.vocabularyName, category.title);
    }
}